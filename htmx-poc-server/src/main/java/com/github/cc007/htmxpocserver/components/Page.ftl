<#-- @ftlvariable name="title" type="java.lang.String" -->
<#-- @ftlvariable name="contentTemplate" type="java.lang.String" -->
<#-- @ftlvariable name="logo" type="java.lang.String" -->
<#include "macros/url.ftl">
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>CC007 - Homepage</title>
  <script src="https://unpkg.com/htmx.org@1.9.12/dist/htmx.min.js"></script>
  <script src="https://unpkg.com/htmx.org@1.9.12/dist/ext/response-targets.js"></script>
  <script src="https://unpkg.com/htmx.org@1.9.12/dist/ext/preload.js"></script>
  <script src="/js/script.js"></script>
  <link rel="stylesheet" href="/css/styles.css">
</head>
<body hx-ext="response-targets, preload">
<div id="header">
  <div id="logo"><@a href="/" otherParams=' preload="mouseover"'><img src="/images/logo.png" alt="${logo}"></@a></div>
  <div id="menu">
      <#include "header/menu.ftl">
  </div>
</div>
<div id="content">
    <#include contentTemplate + ".ftl">
</div>
<div id="footer">
  <@a href="/tos" otherParams=' preload="mouseover"'>Terms of Service</@a> | <@a href="/contact" otherParams=' preload="mouseover"'>Contact</@a> | <@a href="/trigger-error" otherParams=' preload="mouseover"'>Trigger error</@a>
</div>
</body>
</html>