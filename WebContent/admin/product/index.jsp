<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
body {
	margin: 0;
	font-family: Arial, Helvetica, sans-serif;
}
</style>
<link rel="stylesheet" type="text/css" href="/shop/css/topnavi.css" />
<link rel="stylesheet" type="text/css" href="/shop/css/table.css" />
</head>
<body>
	<%@ include file="/inc/admin/topnavi.jsp"%>

	<table>
		<tr>
			<th>First Name</th>
			<th>Last Name</th>
			<th>Points</th>
		</tr>
		<tr>
			<td>Jill</td>
			<td>Smith</td>
			<td>50</td>
		</tr>
		<tr>
			<td>Eve</td>
			<td>Jackson</td>
			<td>94</td>
		</tr>
		<tr>
			<td>Adam</td>
			<td>Johnson</td>
			<td>67</td>
		</tr>
		<tr>
			<td colspan="3">
				<button onClick="location.href='registform.jsp'">상품등록</button>
			</td>
		</tr>
		
	</table>


</body>
</html>









