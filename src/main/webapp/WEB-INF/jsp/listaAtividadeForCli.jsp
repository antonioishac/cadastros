<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="springform" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>

<html>
	
	<tiles:insertDefinition name="template">
		<tiles:putAttribute name="corpo">
					
			<div class="row">
                <div class="col-md-12">
                    <!-- Advanced Tables -->
                    <div class="panel panel-default">
                        <div class="panel-heading">
                             Lista Atividade Fornecedor Cliente
                        </div>
                        <div class="panel-body">
                            <div class="table-responsive">
                                <table class="table table-striped table-bordered table-hover" id="dataTables-example">
                                    <thead>
                                        <tr>
                                            <th>ID</th>
                                            <th>Nome</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <c:forEach items="${listaAtividadeForCli}" var="lista">
                                        	<tr class="gradeA">
                                        		<td>${lista.id}</td>
                                        		<td>${lista.nome}</td>
                                        	</tr>
                                        </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                            
                        </div>
                    </div>
                    <!--End Advanced Tables -->
                </div>
            </div>
            
            <script>
		    	$(document).ready(function () {
		    	    $('#dataTables-example').dataTable();
		        });
		    </script>		    
		    		
		</tiles:putAttribute>
	</tiles:insertDefinition>
</html>