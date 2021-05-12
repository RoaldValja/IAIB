function addRow(){
	var i;
	var getActiveTable = document.getElementById(activeTable);
	var tbody = getActiveTable.childNodes;
	console.log("Lisame rida");
	console.log(tbody[2]);
	console.log(activeTable);
	/*
	var tr = document.createElement('tr');
	console.log(document.getElementsByClassName("tableexport-caption").length);
	if(document.getElementsByClassName("tableexport-caption").length == 0){
		var columns = tbody[0].childNodes[0].childNodes.length;
		var rows = tbody[1].childNodes.length + 2;
	} else {
		var columns = tbody[1].childNodes[0].childNodes.length;
		var rows = tbody[2].childNodes.length + 2;
	}
	for(i = 0; i < columns; i++){
		var getI = i+1;
		rowsStr = rows.toString();
		//console.log(rowsStr.concat('-', getI));
		var td = document.createElement('td');
		td.className = "tableRowClass";
		//td.id = rowsStr.concat('-', getI);
		td.id = activeTable.concat('-', rowsStr, '-', getI);
		td.innerHTML = rowsStr.concat('-', getI);
		td.contentEditable = "true";
		tr.appendChild(td);
	}
	if(document.getElementsByClassName("tableexport-caption").length == 0){
		tbody[1].appendChild(tr);
	} else {
		tbody[2].appendChild(tr);
	}
	*/
	var tr = document.createElement('tr');
	
	var columns = tbody[0].childNodes[0].childNodes.length;
	var rows = tbody[1].childNodes.length + 2;
	var rowsStr = "";
	
	for(i = 0; i < columns; i++){
		var getI = i+1;
		rowsStr = rows.toString();
		//console.log(rowsStr.concat('-', getI));
		var td = document.createElement('td');
		td.className = "tableRowClass";
		//td.id = rowsStr.concat('-', getI);
		td.id = activeTable.concat('-', rowsStr, '-', getI);
		td.innerHTML = rowsStr.concat('-', getI);
		td.contentEditable = "true";
		tr.appendChild(td);
	}
	if(activeTableRow == 0 && activeTableColumn == 0){
		tbody[1].appendChild(tr);
	}
	
	
	if(activeTableRow != 0 && activeTableColumn != 0){
		var rowID = activeTable + "-" + activeTableRow + "-" + activeTableColumn;
		console.log(rowID);
		var rowElement = document.getElementById(rowID);
		console.log(rowElement);
		console.log(rowElement.parentNode);
		//var tableRowObject = rowElement.parentNode;
		//rowElement.parentNode.parentNode.insertBefore(tr, tableRowObject.nextSibling);
		insertAfterRow(tr, rowElement);
	}
	
}

function addRow2(){
	var i;
	var getActiveTable = document.getElementById(activeTable);
	var tbody = getActiveTable.childNodes;
	console.log("Lisame rida");
	console.log(tbody[2]);
	console.log(activeTable);
	
	console.log("siin on rea number!");
	console.log(document.getElementById("tableRow").value);
	
	console.log(parseInt(document.getElementById("tableRow").value, 10));
	
	var tableRowValue = document.getElementById("tableRow").value;
	var newRows = parseInt(tableRowValue, 10);
	var newRowsMax = 1;
	
	if(Number.isInteger(newRows) || tableRowValue == ""){
		console.log("It is a number!");
		if(tableRowValue != ""){
			newRowsMax = newRows;
		}
		
		for(j = 0; j < newRowsMax; j++){
		
			var tr = document.createElement('tr');
			
			var columns = tbody[0].childNodes[0].childNodes.length;
			var rows = tbody[1].childNodes.length + 2;
			var rowsStr = "";
			
			console.log(j + " kordus");
			console.log(rows);
			console.log("i on: " + i);
			for(i = 0; i < columns; i++){
				var getI = i+1;
				rowsStr = rows.toString();
				//console.log(rowsStr.concat('-', getI));
				var td = document.createElement('td');
				td.className = "tableRowClass";
				//td.id = rowsStr.concat('-', getI);
				td.id = activeTable.concat('-', rowsStr, '-', getI);
				td.innerHTML = rowsStr.concat('-', getI);
				td.contentEditable = "true";
				tr.appendChild(td);
			}
			
			if(activeTableRow == 0 && activeTableColumn == 0){
				console.log("Lisab uue table row");
				tbody[1].appendChild(tr);
			}
			
			if(activeTableRow != 0 && activeTableColumn != 0){
				var rowID = activeTable + "-" + activeTableRow + "-" + activeTableColumn;
				console.log(rowID + " RowID!");
				var rowElement = document.getElementById(rowID);
				console.log(rowElement);
				console.log(rowElement.parentNode);
				insertAfterRow(tr, rowElement);
			}
		}
	}
	// Siia tuleb error message! --------------------------------------------------------------------------
		
		
	/*
	
	for(j = 0; j < newRowsMax; j++){
		
		var tr = document.createElement('tr');
		
		var columns = tbody[0].childNodes[0].childNodes.length;
		var rows = tbody[1].childNodes.length + 2;
		var rowsStr = "";
		
		console.log(j + " kordus");
		console.log(rows);
		console.log("i on: " + i);
		for(i = 0; i < columns; i++){
			var getI = i+1;
			rowsStr = rows.toString();
			//console.log(rowsStr.concat('-', getI));
			var td = document.createElement('td');
			td.className = "tableRowClass";
			//td.id = rowsStr.concat('-', getI);
			td.id = activeTable.concat('-', rowsStr, '-', getI);
			td.innerHTML = rowsStr.concat('-', getI);
			td.contentEditable = "true";
			tr.appendChild(td);
		}
		
		if(activeTableRow == 0 && activeTableColumn == 0){
			console.log("Lisab uue table row");
			tbody[1].appendChild(tr);
		}
		
		if(activeTableRow != 0 && activeTableColumn != 0){
			var rowID = activeTable + "-" + activeTableRow + "-" + activeTableColumn;
			console.log(rowID + " RowID!");
			var rowElement = document.getElementById(rowID);
			console.log(rowElement);
			console.log(rowElement.parentNode);
			insertAfterRow(tr, rowElement);
		}
	}
	
	*/
	
	/*
	for(i = 0; i < columns; i++){
		var getI = i+1;
		rowsStr = rows.toString();
		//console.log(rowsStr.concat('-', getI));
		var td = document.createElement('td');
		td.className = "tableRowClass";
		//td.id = rowsStr.concat('-', getI);
		td.id = activeTable.concat('-', rowsStr, '-', getI);
		td.innerHTML = rowsStr.concat('-', getI);
		td.contentEditable = "true";
		tr.appendChild(td);
	}
	if(activeTableRow == 0 && activeTableColumn == 0){
		tbody[1].appendChild(tr);
	}
	
	if(activeTableRow != 0 && activeTableColumn != 0){
		var rowID = activeTable + "-" + activeTableRow + "-" + activeTableColumn;
		console.log(rowID);
		var rowElement = document.getElementById(rowID);
		console.log(rowElement);
		console.log(rowElement.parentNode);
		insertAfterRow(tr, rowElement);
	}
	*/
}

function addColumn(){
	var i;
	var getActiveTable = document.getElementById(activeTable);
	var tbody = getActiveTable.childNodes;
	var th = document.createElement('th');
	var row = "1";
	if(document.getElementsByClassName("tableexport-caption").length == 0){
		var column = tbody[0].childNodes[0].childNodes.length + 1;
		var rows = tbody[1].childNodes.length + 2;
	} else {
		var column = tbody[1].childNodes[0].childNodes.length + 1;
		var rows = tbody[2].childNodes.length + 2;
	}
	
	
	//var rowsStr = rows.toString();
	console.log(column);
	th.className = "tableRowClass";
	//th.id = row.concat('-', column);
	th.id = activeTable.concat('-', row,'-', column);
	th.innerHTML = row.concat('-', column);
	th.contentEditable = "true";
	if(document.getElementsByClassName("tableexport-caption").length == 0){
		tbody[0].childNodes[0].appendChild(th);
	} else {
		tbody[1].childNodes[0].appendChild(th);
	}
	
	var rowsStr;
	for(i = 0; i < rows-2; i++){
		getI = i+2;
		rowsStr = getI.toString();
		var td = document.createElement('td');
		td.className = "tableRowClass";
		//td.id = rowsStr.concat('-', column);
		td.id = activeTable.concat('-', rowsStr, '-', column);
		td.innerHTML = rowsStr.concat('-', column);
		td.contentEditable = "true";
		if(document.getElementsByClassName("tableexport-caption").length == 0){
			tbody[1].childNodes[i].appendChild(td);
		} else {
			tbody[2].childNodes[i].appendChild(td);
		}
	}
	
	var rowID = activeTable + "-" + activeTableRow + "-" + activeTableColumn;
	console.log(rowID);
	var rowElement = document.getElementById(rowID);
	console.log(rowElement);
	console.log(rowElement.parentNode);
	var tableRowObject = rowElement.parentNode;
	rowElement.parentNode.parentNode.insertBefore(tr, tableRowObject.nextSibling);
}

function generateTable(row, column, header){
	var i, j;
	
	if(row == '' && column == '' && header == ''){
		row = document.getElementsByName('getTableRow')[0].value;
		column = document.getElementsByName('getTableColumn')[0].value;
		header = 1;
	}
	console.log(row);
	console.log(column);
	
	var thead = document.createElement('thead');
	var tbody = document.createElement('tbody');
	
	var getActiveTable = document.getElementById(activeTable);
	
	while(getActiveTable.firstChild){
		getActiveTable.removeChild(getActiveTable.firstChild);
	}
	
	for(i = 0; i < row; i++){
		//console.log("in i loop");
		var tr = document.createElement('tr');
			for(j = 0; j < column; j++){
				var td;
				var getI = i+1;
				var getJ = j+1;
				var rowId = getI.toString();
				//console.log(rowId);
				if(i < header){
					td = document.createElement('th');
				} else {
					td = document.createElement('td');
				}
				td.className = "tableRowClass";
				//td.id = rowId.concat('-', getJ);
				td.id = activeTable.concat('-', rowId,'-', getJ);
				td.innerHTML = rowId.concat('-', getJ);
				td.contentEditable = "true";
				tr.appendChild(td);
			}
		if(i == 0){
			thead.appendChild(tr);
			document.getElementById(activeTable).appendChild(thead);
		} else{
			tbody.appendChild(tr);
			document.getElementById(activeTable).appendChild(tbody);
		}
	}
	// proov parandada addrow kui ainult 1 rida tabelis
	if(row == 1){
		document.getElementById(activeTable).appendChild(tbody);
	}
	document.getElementsByName('getTableRow')[0].value = "";
	document.getElementsByName('getTableColumn')[0].value = "";
}

function correctRows(tableRowID){
	var i, j, currentPartId, activeRowId;
	//console.log(document.getElementById(tableRowID).parentNode.previousSibling.childNodes[0].id + " see on tema eelmise rea id -------------------------------");
	//console.log(document.getElementById(tableRowID).parentNode.previousSibling.childNodes.length + " see on tema eelmise rea length -------------------------------");
	var rowLength = document.getElementById(tableRowID).parentNode.childNodes.length;
	var currentRow = document.getElementById(tableRowID).parentNode;
	var rowAmount = currentRow.parentNode.childNodes.length;
	console.log(rowAmount + " mitu rida on!");
	currentRowNumber = parseInt(activeTableRow);
	correctNextRowNumber = currentRowNumber + 1;
	rowAmountLeft = rowAmount - activeTableRow;
	console.log(rowAmountLeft);
	var nextRowID;
	console.log(tableRowID + " SIIN ON TABLEROWID");
	var nextRow = document.getElementById(tableRowID).parentNode.nextSibling;
	console.log(document.getElementById(tableRowID).parentNode);
	console.log(document.getElementById(tableRowID).parentNode.nextSibling);
	for(j = 0; j < rowAmountLeft; j++){
		if(j > 0){
			var nextRow = document.getElementById(currentPartId).parentNode.nextSibling;
		}
		/*
		if(activeTableRow == 1 && j == 0){
			console.log("siin sees");
			nextRowID = document.getElementById(tableRowID).parentNode.parentNode.nextSibling.childNodes[0].childNodes[0].id;
			console.log(nextRowID + " See on müstiline esimese rea id.");
		}
		else {*/
		console.log("--------------------------------------------------------------------------------------------------------");
		console.log(j);
		console.log(nextRow + " SIIN ON NEXTROW");
		nextRowID = nextRow.childNodes[0].id;
		//}
		
		var index1 = nextRowID.indexOf("-");
		var nextRowIDEnd = nextRowID.substring(index1+1);
		var index2 = nextRowIDEnd.indexOf("-");
		var nextRowNumber = nextRowIDEnd.substring(0, index2);
		console.log("previousrownumber on : " + nextRowID);
		console.log("previousrownumber on : " + nextRowIDEnd);
		console.log("previousrownumber on : " + nextRowNumber);
		
		for(i = 1; i < rowLength+1; i++){
			currentPartId = activeTable + "-" + correctNextRowNumber + "-" + i + "uus";
			activeRowId = activeTable + "-" + nextRowNumber + "-" + i;
			console.log("activerowid on: " + activeRowId);
			//document.getElementById(activeRowId).innerHTML = currentPartId;
			document.getElementById(activeRowId).id = currentPartId;
		}
		correctNextRowNumber++;
	}
	
	var changedRowId;
	var changedRow = parseInt(activeTableRow) + 1;
	for(j = 0; j < rowAmountLeft; j++){
		for(i = 1; i < rowLength+1; i++){
			changedRowId = activeTable + "-" + changedRow + "-" + i + "uus";
			changeToRowId = activeTable + "-" + changedRow + "-" + i;
			console.log(changedRowId + " on changedRowId " + changeToRowId + " on changeToRowId");
			document.getElementById(changedRowId).id = changeToRowId;
		}
		changedRow++;
	}
	
}