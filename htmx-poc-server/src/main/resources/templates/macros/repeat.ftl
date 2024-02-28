<#macro repeat n>
    <#list 0..<n as i><#nested i></#list>
</#macro>