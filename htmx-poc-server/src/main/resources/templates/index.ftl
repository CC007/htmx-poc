<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>CQIT - Homepage</title>
  <script src="https://unpkg.com/htmx.org@1.9.10"></script>
  <script src="https://unpkg.com/htmx.org@1.9.10/dist/ext/response-targets.js"></script>
  <link rel="stylesheet" href="/css/styles.css">
</head>
<body hx-ext="response-targets">
<div id="header">
  <div id="logo"><a href="/">${logo}</a></div>
  <div id="menu">
      <#list menuItems as menuItem>
        <a href="${menuItem.url}" hx-get="${menuItem.url}" hx-target="#content" hx-target-*="#content">${menuItem.name}</a>
      </#list>
  </div>
</div>
<div id="content">
    ${content}
</div>
<div id="footer">
  <a href="${tosUrl}" hx-get="${tosUrl}" hx-target="#content" hx-target-*="#content">Terms of Service</a> | <a href="${contactUrl}" hx-get="${contactUrl}" hx-target="#content" hx-target-*="#content">Contact</a>
</div>
</body>
</html>