<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>

<html>

<link rel="stylesheet" href="${pageContext.request.contextPath}/css/global.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/uf/cadastroUf.css" />

<tiles:insertDefinition name="template">	

	<tiles:putAttribute name="corpo">
		
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/uf/cadastro_uf.js"></script>
		
		<c:import url="navegacao.jsp" />

		<form id="ufForm">
			<div class="panel panel-default centroCadastro">
				<div class="panel-heading">Cadastro de Estados</div>
				<div class="panel-body">
				
					<div class="row">
						<div class="col-xs-12 col-sm-6">
								
							<label class="control-label">Pais:</label>
								
 							<select name="pais.id" id="optPais" class="form-control required">
 									
 								<option value="">Selecione</option>
 									
 								<c:forEach var="p" items="${listaPais}">
 										
 									<c:if test="${p.id eq uf.pais.id}">
 										<option selected="selected" value="${p.id}">${p.nomePtBr}</option>
 									</c:if>
 										
 									<c:if test="${p.id ne uf.pais.id}">
 										<option value="${p.id}">${p.nomePtBr}</option>
 									</c:if>
 										
 								</c:forEach>
 							</select>
	      					
						</div>
						
						<div class="col-xs-12 col-sm-6">
							<label for="sigla" class="control-label">Sigla:</label> 
							<input name="sigla" id="siglaInput" value="${uf.sigla}" class="form-control required" />
						</div>
												
					</div>

					<div class="row">
						<div class="col-xs-12 col-sm-6">
							<label for="nome" class="control-label">Nome:</label>
							<input name="nome" id="nomeInput" value="${uf.nome}" class="form-control required" />
						</div>

						<div class="col-xs-12 col-sm-6">
							<label for="codigoIbge" class="control-label">Código Ibge:</label>
							<input name="codigoIbge" id="codigoIbgeInput" value="${uf.codigoIbge}" class="form-control" />
						</div>
					</div>

				</div>
				
				<input type="submit" value="Gravar" class="btn btn-primary btnSalvar">
				
				<br /><br />
				
			</div>			
			
			<input type="hidden" name="id" id="idInput" value="${uf.id}"/>
		</form>

	</tiles:putAttribute>

</tiles:insertDefinition>

</html>