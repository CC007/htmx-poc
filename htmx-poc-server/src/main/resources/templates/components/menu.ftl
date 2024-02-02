<#-- @ftlvariable name="menuItem" type="com.github.cc007.htmxpocserver.model.MenuItem" -->
<#list menuItems as menuItem>
  <a href="${menuItem.url}" hx-get="${menuItem.url}" hx-target="#content" hx-target-*="#content"<#if menuItem.active?? && menuItem.active> class="active"</#if>>${menuItem.name}</a>
</#list>