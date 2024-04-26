<#include "../macros/repeat.ftl">
<#setting time_zone="UTC">
<#if showDescription>
<p>This is an example to demonstrate dynamic loading of content</p>
</#if>
<@repeat n=postCount; postNr>
    <div class="card">
        <div class="card-body">
            <div class="media">
                <div class="media-header">
                    <div class="media-icon">
                        <img class="mr-3 rounded-circle" src="/images/bigben.jpeg" alt="User Icon">
                    </div>
                    <div class="media-info">
                        <h5 class="media-username">Big Ben</h5>
                        <h6 class="media-usertag">@the_bigben_clock</h6>
                    </div>
                    <#assign postTimestamp=timestamp-3600*(postNr+nextOffset-postCount) >
                    <div class="media-time">${(postTimestamp*1000)?number_to_datetime?string.medium}</div>
                </div>
                <div class="media-body">
                    <#assign bongs=((currentHour-postNr-1)%12+12)%12+1 >
                    <p><@repeat n=bongs>BONG </@repeat></p>
                </div>
            </div>
            <div class="btn-group" role="group" aria-label="Post actions">
                <button type="button" class="btn btn-outline-primary">Like</button>
                <button type="button" class="btn btn-outline-primary">Share</button>
                <button type="button" class="btn btn-outline-primary">Reply</button>
            </div>
        </div>
    </div>
</@repeat>
<#if postCount gt 0>
<div hx-trigger="intersect once" hx-swap="outerHTML" hx-get="/bigben?offset=${nextOffset}&timestamp=${timestamp?c}">Load more...</div>
</#if>