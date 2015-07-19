<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<!DOCTYPE html>
<html>
	<tiles:insertDefinition name="template">
		<tiles:putAttribute name="corpo">
			<p align="center">Bem vindo, escolha sua opção logo acima</p>
		</tiles:putAttribute>
	</tiles:insertDefinition>
</html>