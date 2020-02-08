<%@ include file="common/header.jspf"  %>
<%@ include file="common/navigation.jspf"  %>
<!--  Here We will Leave The Containe only .. -->
	<div class="container">
		<!--  Here we Bind the todo attribute in the todoController to the Form -->
		<form:form method="POST" modelAttribute="todo">
			<form:hidden path="id" />
			<!--  The Error is related to the description -->
			<fieldset class="form-group">
				<form:label path="desc">Description : </form:label>
				<form:input path="desc" type="text" class="form-control"
					required="required" />
				<form:errors path="desc" cssClass="text-warning  bottom"></form:errors>
			</fieldset>
			<fieldset class="form-group">
				<form:label path="targetDate">Target Date : </form:label>
				<form:input path="targetDate" type="text" class="form-control"
					required="required" />
				<!-- 	<form:errors path="targetDate" cssClass="text-warning  bottom"></form:errors> -->
			</fieldset>

			<input type="submit" value="Add Query" class="btn btn-success">
		</form:form>
		</div>

<%@ include file="common/footer.jspf"  %>