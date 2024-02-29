<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>CC007 - Homepage</title>
  <script src="https://unpkg.com/htmx.org@1.9.10/dist/htmx.min.js"></script>
  <script src="https://unpkg.com/htmx.org@1.9.10/dist/ext/response-targets.js"></script>
  <script src="/js/script.js"></script>
  <link rel="stylesheet" href="/css/styles.css">
</head>
<body hx-ext="response-targets">
<div id="header">
  <div id="logo"><a href="/" hx-get="/" hx-target="#content" hx-target-*="#content" hx-push-url="true"><img src="/images/logo.png" alt="${logo}"></a></div>
  <div id="menu">
      <#include "components/menu.ftl">
  </div>
</div>
<div id="content">
    <#include contentTemplate + ".ftl">
</div>
<div id="footer">
  <a href="${tosUrl}" hx-get="${tosUrl}" hx-target="#content" hx-target-*="#content" hx-push-url="true">Terms of Service</a> | <a href="${contactUrl}" hx-get="${contactUrl}" hx-target="#content" hx-target-*="#content" hx-push-url="true">Contact</a>
</div>
</body>
</html>