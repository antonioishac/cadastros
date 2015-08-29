<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>

<html>
	
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/global.css" />

	<tiles:insertDefinition name="template">
	
		<tiles:putAttribute name="corpo">
		
			<script src="${pageContext.request.contextPath}/js/lista.js"></script>
		
			<script type="text/javascript">

				var idExcluir;
				
				function excluir(id) {					
	
					idExcluir = id;
											
					$('#modalExcluir').modal('show');
				}
											
				$(document).ready(function(){

					var cep = new lista();

					var config = {
							previous : 'Anterior',
							next : 'Próximo',
							first : 'Primeiro',
							last : 'Último',
							info : 'Mostrando página _PAGE_ de _PAGES_',
							infoEmpty : '',
							zeroRecords : 'Não há registros para serem exibidos',
							funcExcluir : "excluir",
							url : '/cep/listarCep.do?funcExcluir='
						};
										
					cep.setTabela('#tabela_cep',config);
					
					$('#buscar').click(function() {										

						loadTabelaCep();
							
					});

					function loadTabelaCep(){
						var campoLogradouro = $('#inputLogradouro').val();
						
						parametros = '';
												
						if(campoLogradouro != null && $.trim(campoLogradouro) != '') {						

							parametros = "?logradouro=" + campoLogradouro;
							parametros += "&funcExcluir=excluir";
							
						}else {
							parametros = "?funcExcluir=excluir";
						}
						
						cep.atualizar(parametros, '/cep/listarCep.do');
					}

					$('#confirmaExclusao').click(function() {
												
 						$.ajax({
							type: 'get',
							url: '${pageContext.request.contextPath}/cep/removeCep.do',
							data: 'id=' + idExcluir,
							success: function(retorno){

								loadTabelaCep();
								
								$('#modalExcluir').modal('hide');
								
							},
							error: function() {
								alert("Erro ao excluir cep.");
							}
						});						
						
					});

					$('#inputCep').mask('99999-999');
															
				});

			</script>
			
			<c:import url="navegacao.jsp" />
			
			<c:import url="buscaCep.jsp" />
												
			<!-- 						
			<label for="btnIncluir" class="btn btn-primary" >
         		<i class="glyphicon glyphicon-plus"></i> Incluir País
      		</label>
      		<input id="btnIncluir" name="btnIncluir" type="button" class="hidden" />
      		 -->
      						
			<div class="panel panel-default centroCadastro">
  				<div class="panel-heading">Lista de Cep</div>
  				<div class="panel-body">
  					
  					<table id="tabela_cep" class="table table-striped table-bordered cabecalho_tabela " cellspacing="0" width="100%">
						<thead>
							<tr>							
								<th>ID</th>
								
								<th>Logradouro</th>
								
								<th>CEP</th>

								<th>Município</th>
								
								<th>UF</th>
																
								<th>Opções</th>
							</tr>
						</thead>
					</table>
  										
  				</div>
  			</div>
  			
  			<c:import url="../dialogExclusao.jsp" />
		
		</tiles:putAttribute>
	
	</tiles:insertDefinition>

</html>