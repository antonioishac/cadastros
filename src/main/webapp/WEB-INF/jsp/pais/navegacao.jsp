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
			    <li id="listaPais"><a href="${pageContext.request.contextPath}/pais/listaPais.do">Listar</a></li>
			    <li id="cadastraPais"><a href="${pageContext.request.contextPath}/pais/cadastroPais.do">Cadastrar</a></li>
			</ul>			      
		</div><!-- /.navbar-collapse -->
	</div><!-- /.container-fluid -->
</nav>