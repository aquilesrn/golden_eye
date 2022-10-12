<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>GoldenEye test</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
  </head>
  <body>
	  <form method="post" action="saveDetails">   
		  	<div class="container-md">
		  	
			    <div class="input-group">
				  <span class="input-group-text">First and last name</span>
				  <input name = "user1" type="text" aria-label="First name" class="form-control">
				  <input name = "user2" type="text" aria-label="Last name" class="form-control">
				</div>
				
				<div class="input-group mb-3">
				  <label class="input-group-text" for="inputGroupSelect01">Office</label>
				  <select class="form-select" id="office" name = "office">
				    <option selected>Choose Office...</option>
					  <option value="1" data-depts="1,2,3">Milan</option>
					  <option value="2" data-depts="2,4">Spain</option>
					  <option value="3" data-depts="2,3">New York</option>
				  </select>
				</div>
				
				<div class="input-group mb-3">
				  <label class="input-group-text" for="inputGroupSelect01">Department</label>
				  <select class="form-select" id="dept" name = "dept">
				    <option selected>Choose Department...</option>
					  <option value="1">Design</option>
					  <option value="2">Business</option>
					  <option value="3">Advertising</option>
					  <option value="4">Research & development</option>
				  </select>
				</div>
				<input type="submit" value="Submit">
			</div>
		</form>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>
  	<script src="http://code.jquery.com/jquery-1.11.0.min.js"></script>
  	
  		<script>
  	
			$("#office").change(function() {
			  var ids = $(this).find(":selected").data('depts').split(",");
			  var n = null;
			  $('#dept option').hide().filter(function() {
			    var p = ids.indexOf($(this).val()) > -1;
			    if (p && n == null) {
			      n = $(this).val()
			    }
			    return p
			  }).show();
			  $('#dept').show();
			  $('#dept').val(n)
			});
			
		</script>

  </body>
</html>