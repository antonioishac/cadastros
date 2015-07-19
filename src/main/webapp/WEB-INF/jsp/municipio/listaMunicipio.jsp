<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>

<html>
	
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/global.css" />
	<link rel="stylesheet" href="//code.jquery.com/ui/1.10.4/themes/smoothness/jquery-ui.css">
		
	<tiles:insertDefinition name="template">
	
		<tiles:putAttribute name="corpo">
		
			<script src="${pageContext.request.contextPath}/js/municipio/lis_municipio.js"></script>
			<script src="${pageContext.request.contextPath}/js/municipio/autocomplete.js"></script>
			<script src="//code.jquery.com/ui/1.10.4/jquery-ui.js"></script>
		
			<script type="text/javascript">

				var idExcluir;
				
				function excluir(id) {					
	
					idExcluir = id;
											
					$('#modalExcluir').modal('show');
				}
											
				$(document).ready(function(){

					var config = {
							previous : 'Anterior',
							next : 'Próximo',
							first : 'Primeiro',
							last : 'Último',
							info : 'Mostrando página _PAGE_ de _PAGES_',
							infoEmpty : '',
							zeroRecords : 'Não há registros para serem exibidos',
							funcExcluir : "excluir"
						};
										
					municipio.setTabela('#tabela_municipio',config);
					
					$('#buscar').click(function() {										

						loadTabelaMunicipio();
							
					});

					function loadTabelaMunicipio(){
						var campoNome = $("#inputNome").val();
						
						var campoUf = $('#inputUf').val();

						parametros = '';
						
						if(campoNome != null && $.trim(campoNome) != '' || campoUf != null && $.trim(campoUf) != '') {						

							parametros = "?nome=" + campoNome;
							parametros += "&uf=" + campoUf;
							parametros += "&funcExcluir=excluir";								
						}else {
							parametros = "?funcExcluir=excluir";
						}
						
						municipio.atualizar(parametros);
					}

					$('#confirmaExclusao').click(function() {

						//alert('parametro passado: ' + idExcluir);
						
 						$.ajax({
							type: 'get',
							url: '${pageContext.request.contextPath}/municipio/removeMunicipio.do',
							data: 'id=' + idExcluir,
							success: function(retorno){

								loadTabelaPais();
								
								$('#modalExcluir').modal('hide');
								
							},
							error: function() {
								alert("Erro ao excluir municipio.");
							}
						});						
						
					});
															
				});

			</script>
			
			<c:import url="navegacao.jsp" />
			
			<c:import url="buscaMunicipio.jsp" />
					      						
			<div class="panel panel-default centroCadastro">
  				<div class="panel-heading">Lista de Municípios</div>
  				<div class="panel-body">
  					
  					<table id="tabela_municipio" class="table table-striped table-bordered cabecalho_tabela " cellspacing="0" width="100%">
						<thead>
							<tr>							
								<th>ID</th>
								
								<th>UF</th>

								<th>Nome</th>
								
								<th>Código IBGE</th>

								<th>Código Receita Federal</th>
								
								<th>Código Estadual</th>
								
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