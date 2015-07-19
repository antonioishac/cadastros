<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">

<title>Cactus Tecnologia da Informação | Cadastros Base</title>

<link rel="stylesheet" href="http://netdna.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css" />
<link rel="stylesheet" href="http://netdna.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap-theme.min.css" />
<link rel="stylesheet" href="http://code.jquery.com/ui/1.10.3/themes/smoothness/jquery-ui.css" />

<!-- <script type="text/javascript" charset="utf-8" src="http://code.jquery.com/jquery-1.9.1.js"></script> -->
<script charset="utf-8" type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>

<script type="text/javascript" src="http://netdna.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
<script type="text/javascript" src="http://code.jquery.com/ui/1.10.3/jquery-ui.js"></script>

<!-- PLUGIN JQUERY VALIDATOR -->
<script src="${pageContext.request.contextPath}/js/jquery.validate.js"></script>
<script src="${pageContext.request.contextPath}/js/jquery.validate.min.js"></script>

<!-- PLUGIN JQUERY VALIDATOR -->
<script src="${pageContext.request.contextPath}/js/jquery.maskedinput.min.js"></script>

<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery.blockUI/2.66.0-2013.10.09/jquery.blockUI.min.js"></script>

<!-- JS para o componente de datatable -->
<script charset="utf-8" type="text/javascript" src="//cdn.datatables.net/1.10.2/js/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="//cdn.datatables.net/plug-ins/725b2a2115b/integration/bootstrap/3/dataTables.bootstrap.js"></script>

<script type="text/javascript" src="${pageContext.request.contextPath}/js/dataTables.colResize.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/dataTables.colVis.js"></script>

<script type="text/javascript">

	var dominio = "${pageContext.request.contextPath}";

</script>

</head>
<body>

	<nav class="navbar navbar-default" role="navigation">
		<div class="container-fluid">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar-1">
					<span class="sr-only"></span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="${pageContext.request.contextPath}/index.jsp">Dashboard</a>
			</div>
			
			<div class="collapse navbar-collapse" id="navbar-1">
				<ul class="nav navbar-nav">
				
					<li class="dropdown">
						<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">Endereço<span class="caret"></span></a>
						<ul class="dropdown-menu" role="menu">
							<li><a href="${pageContext.request.contextPath}/pais/listaPais.do">País</a></li>
							<li><a href="${pageContext.request.contextPath}/uf/listaUf.do">Estado</a></li>
							<li><a href="${pageContext.request.contextPath}/municipio/listaMunicipio.do">Municipio</a><li>
							<li><a href="#">CEP</a></li>							
						</ul>
					</li>
				
					<li class="dropdown">
						<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">Pessoa<span class="caret"></span></a>
						<ul class="dropdown-menu" role="menu">
							<li><a href="${pageContext.request.contextPath}/preparaCadastroAtividadeForCli.do">Atividade For/Cli</a></li>
							<li><a href="${pageContext.request.contextPath}/atividadeForCli/listar.do">Listar Atividade For/Cli</a>
						</ul>
					</li>					
				</ul>
			</div>
		</div>
	</nav>
		
	<div class="panel panel-default">
		<div class="panel-body">
		
			<div id="mensagem"></div>
		
			<tiles:insertAttribute name="corpo" />
		</div>
	</div>

</body>
</html>