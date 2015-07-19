			<!-- DIALOG PARA INCLUIR -->
			<div id="modalIncluir" class="modal fade">
			    <div class="modal-dialog">
			        <div class="modal-content">
			            <div class="modal-header">
			                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
			                <h4 class="modal-title">Incluir País</h4>
			            </div>
			            <div class="modal-body">
			                			                
			                <form id="paisForm">				
								<div class="panel panel-primary">
				  					<div class="panel-heading">Cadastro de País</div>
				  					<div class="panel-body">
				    					
				    					<div class="row">				    						
				    						<div class="col-xs-12 col-sm-6">
				    							<label for="codigo" class="control-label">Código:</label>
												<input name="nome" id="nomeInput" value="${pais.codigo}" class="form-control required" />				    						
				    						</div>
				    						
				    						<div class="col-xs-12 col-sm-6">
				    							<label for="nomeEn" class="control-label">Nome-En:</label>
												<input name="nomeEn" id="nomeEnInput" value="${pais.nomeEn}" class="form-control required" />
				    						</div>
										</div>
										
										<div class="row">
				    						<div class="col-xs-12 col-sm-6">
				    							<label for="nomePtBr" class="control-label">Nome PtBr:</label>
												<input name="nome" id="nomeInput" value="${pais.nomePtBr}" class="form-control required" />				    						
				    						</div>
				    										    						
				    						<div class="col-xs-12 col-sm-6">
				    							<label for="sigla2" class="control-label">Sigla 2:</label>
												<input name="sigla2" id="sigla2Input" value="${pais.sigla2}" class="form-control required" />				    						
				    						</div>																	
										</div>
										
										<div class="row">
				    						<div class="col-xs-12 col-sm-6">
				    							<label for="sigla3" class="control-label">Sigla 3:</label>
												<input name="sigla3" id="sigla3Input" value="${pais.sigla3}" class="form-control required" />				    						
				    						</div>																	
										</div>								
																						
				  					</div>
				  				</div>
				  							
							</form>
			                
			            </div>
			            
			            <div class="modal-footer">			                
			                <button type="button" id="inclusao" class="btn btn-primary">Cadastrar</button>
			            </div>
			            
			        </div>
			    </div>
			</div>