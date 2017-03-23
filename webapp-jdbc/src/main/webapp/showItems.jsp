<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>All items</title>
</head>
<body>
<h1>All items</h1>
<p>
    The following list of items was retrieved as follows:
</p>
<ul>
    <li> After entering http://localhost:8080/showItems in the address-bar, your browser sent a GET-request to the TomEE
        server.
    </li>
    <li> The TomEE server forwards the request to the servlet "ShowItemController", which listens to this URL</li>
    <li> The servlet then used a webclient to connect to the JAX Restful webservice "ItemService", which listens on
        http://localhost:8080/items
    </li>
    <li>The webservice used the injected DAO to retrieve data and returned it in the form of JSON objects to the
        servlet
    </li>
    <li>The webclient-object used in the servlet translates the JSON object back to POJOs</li>
    <li>Then the servlet put the retrieved data into the request-object and forwarded the request to the
        showItems.jsp
    </li>
    <li>The showItems.jsp reads the data from the request and prints the names of the items as HTML code</li>
    <li> The jsp sends the created HTML-code back to the browser, which shows this page.</li>

</ul>


<c:forEach items="${requestScope.allItems}" var="item">
    Item: ${item.name} <br/>
</c:forEach>
</body>
</html>
