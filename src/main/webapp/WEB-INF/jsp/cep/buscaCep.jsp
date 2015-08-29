<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="panel-group centroCadastro" id="accordion">

	<div class="panel panel-default">
	    	
    	<div class="panel-heading">    	
    		<h4 class="panel-title">
	        	<a data-toggle="collapse" data-parent="#accordion" href="#collapseOne">
	          		Buscar Cep
	        	</a>
      		</h4>    	
    	</div>
    	
    	<div id="collapseOne" class="panel-collapse collapse">
      		<div class="panel-body">
        		
        		<form action="" method="get">

					<div class="row">
						
						<div class="col-xs-12 col-sm-6">						
							<label for="logradouro" class="control-label">Logradouro:</label> 
							<input type="text" id="inputLogradouro" name="logradouro" class="form-control" />
						</div>
						
						<div class="col-xs-12 col-sm-6">						
							<label for="cep" class="control-label">CEP:</label> 
							<input type="text" id="inputCep" name="cep" class="form-control" />
						</div>
						
						<div class="col-xs-12 col-sm-6">						
							<label for="municipio" class="control-label">Municipio:</label> 
							<input type="text" id="inputMunicipio" name="municipio" class="form-control" />
						</div>
						
						<div class="col-xs-12 col-sm-6">
								
							<label class="control-label">UF:</label>
								
 							<select name="uf" id="optUf" class="form-control">
 									
 								<option value="">Selecione</option>
 									
 								<c:forEach var="u" items="${listaUf}">
 									 									 										
 									<option value="${u.sigla}">${u.nome}</option> 									
 										
 								</c:forEach>
 							</select> 							
	      					
						</div>
																														
						<span style="margin-bottom: 5px;"></span>
					</div>
					
					<br/>
					
					<div class="form-group">
						<input type="button" id="buscar" value="Buscar" class="btn btn-success">
						<input type="button" id="limpar" value="Limpar" class="btn btn-inverse">
					</div>
				
				</form>
        		
      		</div>
    	</div>
	
	</div>
	
</div>