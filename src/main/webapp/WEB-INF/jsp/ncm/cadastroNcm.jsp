<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>

<html>

<link rel="stylesheet" href="${pageContext.request.contextPath}/css/global.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/ncm/cadastroNcm.css" />
<link rel="stylesheet" href="//code.jquery.com/ui/1.10.4/themes/smoothness/jquery-ui.css">

<tiles:insertDefinition name="template">

	<tiles:putAttribute name="corpo">
		
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/ncm/cadastro_ncm.js"></script>
				
		<c:import url="navegacao.jsp" />

		<form id="ncmForm">
			<div class="panel panel-default centroCadastro">
				<div class="panel-heading">Cadastro de NCM</div>
				<div id="divCadastro" class="panel-body">

					<div class="row">
						<div class="search-container col-xs-12 col-sm-6">
							<label for="uf" class="control-label">Código:</label>							
							<input type="text" id="inputCodigo" name="codigo" value="${ncm.codigo}" class="search form-control required" />													
						</div>
												
						<div class="col-xs-12 col-sm-6">
							<label for="descricao" class="control-label">Descrição:</label> 
							<input name="descricao" id="inputDescricao" value="${ncm.descricao}" class="form-control required" />
						</div>
					</div>

					<div class="row">
						<div class="col-xs-12 col-md-12">
							<label for="observacao" class="control-label">Observação:</label> 
							<textarea name="observacao" id="inputObservacao" class="form-control" rows="2">${ncm.observacao}</textarea>
						</div>
					</div>					

				</div>
				
				<input type="submit" value="Gravar" class="btn btn-primary btnSalvar">
				
				<br /><br />
				
			</div>			
			
			
			<input type="hidden" name="id" value="${ncm.id}"/>
			
		</form>

	</tiles:putAttribute>

</tiles:insertDefinition>

</html>