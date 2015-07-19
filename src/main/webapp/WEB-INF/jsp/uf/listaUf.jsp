<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>

<html>
	
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/global.css" />

	<tiles:insertDefinition name="template">
	
		<tiles:putAttribute name="corpo">
		
			<script src="${pageContext.request.contextPath}/js/uf/lis_uf.js"></script>
		
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
										
					uf.setTabela('#tabela_uf',config);
					
					$('#buscar').click(function() {										

						loadTabelaUf();
							
					});

					function loadTabelaUf(){
						var campoNome = $("#inputNome").val();
						
						var campoSigla = $('#inputSigla').val();

						parametros = '';
						
						if(campoNome != null && $.trim(campoNome) != '' || campoSigla != null && $.trim(campoSigla) != '') {						

							parametros = "?nome=" + campoNome;
							parametros += "&sigla=" + campoSigla;
							parametros += "&funcExcluir=excluir";								
						}else {
							parametros = "?funcExcluir=excluir";
						}
						
						uf.atualizar(parametros);
					}

					$('#confirmaExclusao').click(function() {

						//alert('parametro passado: ' + idExcluir);
						
 						$.ajax({
							type: 'get',
							url: '${pageContext.request.contextPath}/uf/removeUf.do',
							data: 'id=' + idExcluir,
							success: function(retorno){

								loadTabelaUf();
								
								$('#modalExcluir').modal('hide');
								
							},
							error: function() {
								alert("Erro ao excluir cidade.");
							}
						});						
						
					});
															
				});

			</script>
			
			<c:import url="navegacao.jsp" />
			
			<c:import url="buscaUf.jsp" />									
			      						
			<div class="panel panel-default centroCadastro">
  				<div class="panel-heading">Lista de Estados</div>
  				<div class="panel-body">
  					
  					<table id="tabela_uf" class="table table-striped table-bordered cabecalho_tabela " cellspacing="0" width="100%">
						<thead>
							<tr>							
								<th>ID</th>
								
								<th>País</th>

								<th>Sigla</th>
								
								<th>Nome</th>								
								
								<th>Código IBGE</th>
								
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