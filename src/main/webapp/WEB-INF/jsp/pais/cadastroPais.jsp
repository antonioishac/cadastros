<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>

<html>

<link rel="stylesheet" href="${pageContext.request.contextPath}/css/global.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/pais/cadastroPais.css" />

<tiles:insertDefinition name="template">	

	<tiles:putAttribute name="corpo">
		
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/pais/cadastro_pais.js"></script>
		
		<c:import url="navegacao.jsp" />

		<form id="paisForm">
			<div class="panel panel-default centroCadastro">
				<div class="panel-heading">Cadastro de País</div>
				<div class="panel-body">

					<div class="row">
						<div class="col-xs-12 col-sm-6">
							<label for="codigo" class="control-label">Código:</label>
							<input name="codigo" id="codigoInput" value="${pais.codigo}" class="form-control" />
						</div>

						<div class="col-xs-12 col-sm-6">
							<label for="nomeEn" class="control-label">Nome-En:</label> 
							<input name="nomeEn" id="nomeEnInput" value="${pais.nomeEn}" class="form-control" />
						</div>
					</div>

					<div class="row">
						<div class="col-xs-12 col-sm-6">
							<label for="nomePtBr" class="control-label">Nome PtBr:</label>
							<input name="nomePtBr" id="nomePtBrInput" value="${pais.nomePtBr}" class="form-control required" />
						</div>

						<div class="col-xs-12 col-sm-6">
							<label for="sigla2" class="control-label">Sigla 2:</label>
							<input name="sigla2" id="sigla2Input" value="${pais.sigla2}" class="form-control required" />
						</div>
					</div>

					<div class="row">
						<div class="col-xs-12 col-sm-6">
							<label for="sigla3" class="control-label">Sigla 3:</label>
							<input name="sigla3" id="sigla3Input" value="${pais.sigla3}" class="form-control" />
						</div>
					</div>

				</div>
				
				<input type="submit" value="Gravar" class="btn btn-primary btnSalvar">
				
				<br /><br />
				
			</div>			
			
			<input type="hidden" name="id" value="${pais.id}"/>
		</form>

	</tiles:putAttribute>

</tiles:insertDefinition>

</html>