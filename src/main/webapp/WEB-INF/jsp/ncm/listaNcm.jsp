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

					var ncm = new lista();

					var config = {
							previous : 'Anterior',
							next : 'Próximo',
							first : 'Primeiro',
							last : 'Último',
							info : 'Mostrando página _PAGE_ de _PAGES_',
							infoEmpty : '',
							zeroRecords : 'Não há registros para serem exibidos',
							funcExcluir : "excluir",
							url : '/ncm/listarNcm.do?funcExcluir='
						};
										
					ncm.setTabela('#tabela_ncm',config);
					
					$('#buscar').click(function() {										

						loadTabelaNcm();
							
					});

					function loadTabelaNcm(){
						var campoCodigo = $('#inputCodigo').val();
						var campoDescricao = $('#inputDescricao').val();
						
						parametros = '';
												
						if(campoCodigo != null && $.trim(campoCodigo) != '' || 
								campoDescricao != null && $.trim(campoDescricao) != '') {						

							parametros = "?codigo=" + campoCodigo;
							parametros += "&descricao=" + campoDescricao;
							parametros += "&funcExcluir=excluir";
							
						}else {
							parametros = "?funcExcluir=excluir";
						}
						
						ncm.atualizar(parametros, '/ncm/listarNcm.do');
					}

					$('#confirmaExclusao').click(function() {
												
 						$.ajax({
							type: 'get',
							url: '${pageContext.request.contextPath}/ncm/removeNcm.do',
							data: 'id=' + idExcluir,
							success: function(retorno){

								loadTabelaNcm();
								
								$('#modalExcluir').modal('hide');
								
							},
							error: function() {
								alert("Erro ao excluir ncm.");
							}
						});						
						
					});
																				
				});

			</script>
			
			<c:import url="navegacao.jsp" />
			
			<c:import url="buscaNcm.jsp" />
						      						
			<div class="panel panel-default centroCadastro">
  				<div class="panel-heading">Lista NCM</div>
  				<div class="panel-body">
  					
  					<table id="tabela_ncm" class="table table-striped table-bordered cabecalho_tabela " cellspacing="0" width="100%">
						<thead>
							<tr>							
								<th>ID</th>
								
								<th>Código</th>
								
								<th>Descrição</th>
																
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