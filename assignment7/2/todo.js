document.addEventListener("DOMContentLoaded", whenLoaded);
function whenLoaded() {
	var btnSubmit = document.getElementById("submit");
	var btnClear = document.getElementById("clear");
	var field = document.getElementById("input");

	btnSubmit.addEventListener("click", submit);
	btnClear.addEventListener("click", clear);

	var chks = 3;

	function submit () {
		var desc = field.value;
		if (desc) {
			chks ++;

			var ul = document.getElementById("list");
			var li = document.createElement("li");

			var input = document.createElement("input");
			input.type = "checkbox";
			input.id = "chk" + chks;

			var text = document.createTextNode(desc);

			li.appendChild(input);
			li.appendChild(text);
			ul.appendChild(li);

			field.value = "";
		}
	}
	function clear () {
		var list = document.getElementById("list");
		var length = chks;

		for (var i = 0; i < length; i++) {
			var chk = document.getElementById("list").children[i];

			var checked = chk.children[0].checked;
			if(checked){
				chk.remove();
				length--;
				chks--;
				i--;
			}
		}
	}
}