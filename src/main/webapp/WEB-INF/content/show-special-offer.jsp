<!DOCTYPE html >
<%@ page contentType="text/html; charset=iso-8859-1"
	pageEncoding="iso-8859-1" language="java"
	import="java.util.*, com.miw.model.Book,com.miw.presentation.book.*"
	errorPage=""%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page isELIgnored="false"%>

<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">

<head>
<title>Amazin</title>
<link rel="stylesheet" href="css/style.css" />
</head>
<body>
	<header>
		<h1 class="header"><s:text name="header" /></h1>
		<h2 class="centered"><s:text name="welcome" /></h2>
	</header>
	<nav>
		<ul>
			<li><a href="#"><s:text name="start" /></a></li>
			<li><a href="http://miw.uniovi.es"><s:text name="about" /></a></li>
			<li><a href="mailto:dd@email.com"><s:text name="contact" /></a></li>
			<li><a href="logout.action"><s:text name="logout" /></a></li>
		</ul>
	</nav>
	<section>		
		<article>
			<table>
				<caption><s:text name="captionShowSpecialOffer" /></caption>
				<thead>
					<tr>
						<th><s:text name="bookTitle" /></th>
						<th><s:text name="bookAuthor" /></th>
						<th><s:text name="bookDescription" /></th>
						<th><s:text name="bookPrice" /></th>
					</tr>
				</thead>

				<tbody>
					<tr>
						<td><s:property value="#request.book.title" /></td>
						<td><s:property value="#request.book.author" /></td>
						<td><s:property value="#request.book.description" /></td>
						<td><s:property value="#request.book.price" /> &euro;</td>
					</tr>
				</tbody>
			</table>
		</article>
	</section>
	<footer>
		<strong><s:text name="footer1" /> </strong><br /> <em><s:text name="footer2" /></em>
	</footer>
</body>