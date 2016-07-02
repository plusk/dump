document.addEventListener("DOMContentLoaded", whenLoaded);
function whenLoaded() {
	var btn1 = document.getElementById("sort-button-1");
	var btn2 = document.getElementById("sort-button-2");
	var btn3 = document.getElementById("sort-button-3");

	var table = document.getElementById("the-table-body");

	btn1.onclick = function() {
		sorter(0);
	}
	btn2.onclick = function() {
		sorter(1);
	}
	btn3.onclick = function() {
		sorter(2);
	}

	function sorter(col) {
		// legg data i array
		var rows = Array.prototype.slice.call(table.children, 0)

		// sorter dataen i array
		function comparator(a,b) {
			if(a.children.item(col).innerHTML == b.children.item(col).innerHTML){
				return 0
			}
			else if (a.children.item(col).innerHTML < b.children.item(col).innerHTML){
				return -1
			}
			else if (a.children.item(col).innerHTML > b.children.item(col).innerHTML){
				return 1
			}
		}
		rows.sort(comparator)

		// plasser data tilbake
		for(var i = 0; i < rows.length; i++) {
			table.appendChild(rows[i])
		}
	}
}