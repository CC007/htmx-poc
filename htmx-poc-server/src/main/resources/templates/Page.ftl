<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>CC007 - ${title}</title>
  <script src="https://unpkg.com/htmx.org@1.9.10/dist/htmx.min.js"></script>
  <script src="https://unpkg.com/htmx.org@1.9.10/dist/ext/response-targets.js"></script>
  <script src="/js/script.js"></script>
  <link rel="stylesheet" href="/css/styles.css">
</head>
<body hx-ext="response-targets">
<div id="header">
  <div id="logo"><@a href="/"><img src="/images/logo.png" alt="${logo}"></@a></div>
  <div id="menu">
      <#include "header/Menu.ftl">
  </div>
</div>
<div id="content">
    <div>test</div>
</div>
<div id="footer">
  <@a href="/tos">Terms of Service</@a> | <@a href="/contact">Contact</@a> | <@a href="/trigger-error">Trigger error</@a>
</div>
</body>
</html>