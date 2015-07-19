<div class="panel-group centroCadastro" id="accordion">

	<div class="panel panel-default">
	    	
    	<div class="panel-heading">    	
    		<h4 class="panel-title">
	        	<a data-toggle="collapse" data-parent="#accordion" href="#collapseOne">
	          		Buscar Município
	        	</a>
      		</h4>    	
    	</div>
    	
    	<div id="collapseOne" class="panel-collapse collapse">
      		<div class="panel-body">
        		
        		<form action="" method="get">

					<div class="row">
						
						<div class="col-xs-12 col-sm-6">						
							<label for="nome" class="control-label">Nome:</label> 
							<input type="text" id="inputNome" name="nome" class="form-control" />
						</div>
						
						<div class="search-container col-xs-12 col-sm-6">
							<label for="uf" class="control-label">UF:</label> 
							<div class="ui-widget">
								<input type="text" id="inputUf" name="Uf" class="search form-control" />
							</div>
						</div>
																		
						<span style="margin-bottom: 5px;"></span>
					</div>
					
					<br/>
					
					<div class="form-group">
						<input type="button" id="buscar" value="Buscar" class="btn btn-success">
						<input type="button" id="limpar" value="Limpar" onclick="limpaBusca();" class="btn btn-inverse">
					</div>
				
				</form>
        		
      		</div>
    	</div>
	
	</div>
	
</div>