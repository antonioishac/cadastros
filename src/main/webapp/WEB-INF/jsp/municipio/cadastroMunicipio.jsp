<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>

<html>

<link rel="stylesheet" href="${pageContext.request.contextPath}/css/global.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/municipio/cadastroMunicipio.css" />
<link rel="stylesheet" href="//code.jquery.com/ui/1.10.4/themes/smoothness/jquery-ui.css">

<tiles:insertDefinition name="template">	

	<tiles:putAttribute name="corpo">
		
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/municipio/cadastro_municipio.js"></script>
		<script src="${pageContext.request.contextPath}/js/municipio/autocomplete.js"></script>
		<script src="//code.jquery.com/ui/1.10.4/jquery-ui.js"></script>
		
		<c:import url="navegacao.jsp" />

		<form id="municipioForm">
			<div class="panel panel-default centroCadastro">
				<div class="panel-heading">Cadastro de Municipio</div>
				<div class="panel-body">

					<div class="row">
						<div class="search-container col-xs-12 col-sm-6">
							<label for="uf" class="control-label">UF:</label> 
							<div class="ui-widget">
								<input type="text" id="inputUf" name="ufInput" value="${municipio.uf.nome}" class="search form-control required" />								
							</div>
						</div>

						<div class="col-xs-12 col-sm-6">
							<label for="nome" class="control-label">Nome:</label> 
							<input name="nome" id="nomeInput" value="${municipio.nome}" class="form-control required" />
						</div>
					</div>

					<div class="row">
						<div class="col-xs-12 col-sm-6">
							<label for="codigoIbge" class="control-label">Código IBGE:</label>
							<input name="codigoIbge" id="codigoIbgeInput" value="${municipio.codigoIbge}" class="form-control" />
						</div>

						<div class="col-xs-12 col-sm-6">
							<label for="codigoReceitaFederal" class="control-label">Código Receita Federal:</label>
							<input name="codigoReceitaFederal" id="codigoReceitaFederalInput" value="${municipio.codigoReceitaFederal}" class="form-control required" />
						</div>
					</div>

					<div class="row">
						<div class="col-xs-12 col-sm-6">
							<label for="codigoEstadual" class="control-label">Código Estadual:</label>
							<input name="codigoEstadual" id="codigoEstadualInput" value="${municipio.codigoEstadual}" class="form-control" />
						</div>
					</div>

				</div>
				
				<input type="submit" value="Gravar" class="btn btn-primary btnSalvar">
				
				<br /><br />
				
			</div>			
			
			<input type="hidden" id="inputUfId" name="uf.id">
			<input type="hidden" name="id" value="${municipio.id}"/>
			
		</form>

	</tiles:putAttribute>

</tiles:insertDefinition>

</html>