<#-- @ftlvariable name="menuItems" type="java.util.List<com.github.cc007.htmxpocserver.model.MenuItem>" -->
<#include "../macros/url.ftl">
<#list menuItems as menuItem>
  <#assign activeParam=(menuItem.active?? && menuItem.active)?then(' class="active"','') >
  <@a href="${menuItem.url}" otherParams=(activeParam + ' preload="mouseover"')>${menuItem.name}</@a>
</#list>