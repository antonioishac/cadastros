<nav class="navbar navbar-default centroCadastro">
	<div class="container-fluid">
		<!-- Brand and toggle get grouped for better mobile display -->
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
			    <span class="sr-only">Toggle navigation</span>
			    <span class="icon-bar"></span>
			    <span class="icon-bar"></span>
			    <span class="icon-bar"></span>
			</button>
			<!-- <a class="navbar-brand" href="#">Opções</a> -->
	    </div>
			
	    <!-- Collect the nav links, forms, and other content for toggling -->
		<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav">			    			    
			    <li id="listaCep"><a href="${pageContext.request.contextPath}/cep/listaCep.do">Listar</a></li>
			    <li id="cadastraCep"><a href="${pageContext.request.contextPath}/cep/cadastroCep.do">Cadastrar</a></li>
			</ul>			      
		</div><!-- /.navbar-collapse -->
	</div><!-- /.container-fluid -->
</nav>