<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>

<html>
	
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/global.css" />

	<tiles:insertDefinition name="template">
	
		<tiles:putAttribute name="corpo">
		
			<script src="${pageContext.request.contextPath}/js/pais/lis_pais.js"></script>
		
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
										
					pais.setTabela('#tabela_pais',config);
					
					$('#buscar').click(function() {										

						loadTabelaPais();
							
					});

					function loadTabelaPais(){
						var campoNome = $("#inputNome").val();
						
						var campoCodigo = $('#inputCodigo').val();

						parametros = '';
						
						if(campoNome != null && $.trim(campoNome) != '' || campoCodigo != null && $.trim(campoCodigo) != '') {						

							parametros = "?nome=" + campoNome;
							parametros += "&codigo=" + campoCodigo;
							parametros += "&funcExcluir=excluir";								
						}else {
							parametros = "?funcExcluir=excluir";
						}
						
						pais.atualizar(parametros);
					}

					$('#confirmaExclusao').click(function() {

						//alert('parametro passado: ' + idExcluir);
						
 						$.ajax({
							type: 'get',
							url: '${pageContext.request.contextPath}/pais/removePais.do',
							data: 'id=' + idExcluir,
							success: function(retorno){

								loadTabelaPais();
								
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
			
			<c:import url="buscaPais.jsp" />
			<c:import url="modalIncluirPais.jsp" />
									
			<!-- 						
			<label for="btnIncluir" class="btn btn-primary" >
         		<i class="glyphicon glyphicon-plus"></i> Incluir País
      		</label>
      		<input id="btnIncluir" name="btnIncluir" type="button" class="hidden" />
      		 -->
      						
			<div class="panel panel-default centroCadastro">
  				<div class="panel-heading">Lista de Pais</div>
  				<div class="panel-body">
  					
  					<table id="tabela_pais" class="table table-striped table-bordered cabecalho_tabela " cellspacing="0" width="100%">
						<thead>
							<tr>							
								<th>ID</th>
								
								<th>Código</th>

								<th>Nome EN</th>
								
								<th>Nome PtBr</th>

								<th>Sigla 2</th>
								
								<th>Sigla 3</th>
								
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