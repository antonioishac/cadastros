<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>

<html>

<link rel="stylesheet" href="${pageContext.request.contextPath}/css/global.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/cep/cadastroCep.css" />

<tiles:insertDefinition name="template">	

	<tiles:putAttribute name="corpo">
		
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/cep/cadastro_cep.js"></script>
		
		
		<c:import url="navegacao.jsp" />

		<form id="cepForm">
			<div class="panel panel-default centroCadastro">
				<div class="panel-heading">Cadastro de CEP</div>
				<div class="panel-body">

					<div class="row">																		
						<div class="col-xs-12 col-sm-6">
							<label for="cep" class="control-label">Cep:</label> 
							<input name="cep" id="inputCep" value="${cep.cep}" class="form-control required" />
						</div>
						
						<div class="col-xs-12 col-sm-6">
							<label for="logradouro" class="control-label">Logradouro:</label> 
							<input name="logradouro" id="inputLogradouro" value="${cep.logradouro}" class="form-control required" />
						</div>
					</div>

					<div class="row">
						<div class="col-xs-12 col-sm-6">
							<label for="complemento" class="control-label">Complemento:</label>
							<input name="complemento" id="inputComplemento" value="${cep.complemento}" class="form-control" />
						</div>

						<div class="col-xs-12 col-sm-6">
							<label for="bairro" class="control-label">Bairro:</label>
							<input name="bairro" id="inputBairro" value="${cep.bairro}" class="form-control" />
						</div>
					</div>

					<div class="row">
						<div class="col-xs-12 col-sm-6">
							<label for="municipio" class="control-label">Município:</label>
							<input name="municipio" id="inputMunicipio" value="${cep.municipio}" class="form-control" />
						</div>
						
						<div class="col-xs-12 col-sm-6">
								
							<label class="control-label">UF:</label>
								
 							<select name="uf" id="optUf" class="form-control">
 									
 								<option value="">Selecione</option>
 									
 								<c:forEach var="u" items="${listaUf}">
 									
 									<c:if test="${u.sigla eq cep.uf}">
 										<option selected="selected" value="${u.sigla}">${u.nome}</option> 										
 									</c:if>
 										
 									<c:if test="${u.sigla ne cep.uf}">
 										<option value="${u.sigla}">${u.nome}</option>
 									</c:if>
 										
 								</c:forEach>
 							</select>
 							
	      					
						</div>
					</div>
					
					<div class="row">
						<div class="col-xs-12 col-sm-6">
							<label for="codigoIbgeMunicipio" class="control-label">Código Ibge:</label>
							<input name="codigoIbgeMunicipio" id="inputCodigoIbgeMunicipio" value="${cep.codigoIbgeMunicipio}" class="form-control" />
						</div>						
					</div>

				</div>
				
				<input type="submit" value="Gravar" class="btn btn-primary btnSalvar">
				
				<br /><br />
				
			</div>			
			
			
			<input type="hidden" name="id" value="${cep.id}"/>
			
		</form>

	</tiles:putAttribute>

</tiles:insertDefinition>

</html>