<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="springform" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>

<html>
	
	<tiles:insertDefinition name="template">
		<tiles:putAttribute name="corpo">
		
			<h1>Cadastro - Atividade Fornecedor Cliente</h1>
			
			<springform:form method="post" commandName="atividadeForCli" action="${pageContext.request.contextPath}/atividadeForCli/cadastrar.do">
				
				<div style="width: 900px;">
				
					<div class="form-group">
						<label for="nome" class="control-label">Nome:</label>
						<springform:input path="nome" id="nomeInput" cssClass="form-control" />						
					</div>					
					
					<div class="form-group">
						<label for="descricao" class="control-label">Descrição:</label>
						<springform:input path="descricao" id="descricaoInput" cssClass="form-control" />						
					</div>			
				    			    					
				</div>
				
				<input type="submit" value="Gravar" class="btn btn-primary">
				
			</springform:form>
			
		</tiles:putAttribute>
	</tiles:insertDefinition>
	
</html>