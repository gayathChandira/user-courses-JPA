<#import "/spring.ftl" as spring>
<html>
<h1>Users</h1>
<ul>
<#list users as user>
    <li>${user}</li>
</#list>
</ul>
<br>
<a href="/logout">Logout</a>
</html>