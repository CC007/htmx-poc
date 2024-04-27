<#-- @ftlvariable name="title" type="java.lang.String" -->
<#-- @ftlvariable name="contentTemplate" type="java.lang.String" -->
<title>CC007 - ${title}</title>
<div id="menu" hx-swap-oob="true">
    <#include "header/menu.ftl">
</div>
<#include contentTemplate + ".ftl">