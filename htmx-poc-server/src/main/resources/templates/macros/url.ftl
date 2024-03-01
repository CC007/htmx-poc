<#macro a href target='#content' otherParams=''>
    <a href="${href}" hx-get="${href}" hx-target="${target}" hx-target-*="${target}" hx-push-url="true"${otherParams}><#nested></a>
</#macro>