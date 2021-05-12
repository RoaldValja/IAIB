var activeTable;

function getActiveTable(){
	console.log(activeTable);
}

function sleep(ms) {
      return new Promise(resolve => setTimeout(resolve, ms));
   }

async function planProject(){
	var i;
	var JSON_Data;
	var numOfTables;
	var numOfTableSlots;
	var numOfRows;
	var numOfColumns;
	var tableName, tableID;
	//setTimeout(addJSONPlanData, 10000);
	addJSONPlanData();
	await sleep(1000);
	loadJSON(function(response) {
	  // Parse JSON string into object
		JSON_Data = JSON.parse(response);
		console.log(JSON_Data);
		numOfTables = JSON_Data.table.length;
		newProject('tab2');
		for(i = 0; i < numOfTables; i++){
			numOfTableSlots = JSON_Data.table[i].tableSlot.length;
			numOfRows = JSON_Data.table[i].tableSlot[numOfTableSlots-1].row;
			numOfColumns = JSON_Data.table[i].tableSlot[numOfTableSlots-1].column;
			tableID = JSON_Data.table[i].name.concat('Planned');
			tableName = tableID.substring(5);
			//console.log(tableName);
			addTab(tableName, 'tabs2');
			showTab(tableID);
			generateTable(numOfRows, numOfColumns, 1);
			fillTableFromJSON(JSON_Data, numOfRows, numOfColumns, tableID, i);
		}
	 });
}

function addJSONPlanData(){
	var tableData, tableName, tableLength;
	var table = document.getElementsByClassName("table");
	var jsonTable = '{ "table": [ ';
	for(i = 0; i < table.length; i++){
		//jsonTable = jsonTable.concat("{ ");
		tableName = table[i].id;
		tableData = getTableData(tableName);
		tableLengthRow = tableData.length;
		tableLengthColumn = tableData[0].length;
		jsonTable = jsonTable.concat(writeJSONObject(tableName, tableLengthRow, tableLengthColumn, tableData));
		if(i != table.length-1){
			jsonTable = jsonTable.concat(", ");
		}
	}
	jsonTable = jsonTable.concat(' ] }');
	
	//var fs = require('fs');
	//fs.writeFile('json/planData2.json', json, 'utf8', callback);
	var xhr = new XMLHttpRequest();
	var url = "submit.php";
	xhr.open("POST", url, true);
	xhr.setRequestHeader("Content-Type", "application/json; charset = utf-8");
	xhr.onreadystatechange = function () { 
		if (xhr.readyState === 4 && xhr.status === 200) { 
			document.getElementById("result").innerHTML = this.responseText; 
		} 
	}; 
	var data = JSON.stringify(jsonTable);
	
	xhr.send(data);
	
	console.log(jsonTable);
	
}

function writeJSONObject(name, lengthRow, lengthColumn, data){
	var i, j;
	var jsonTable;
	jsonTable = '{ "name":"';
	jsonTable = jsonTable.concat(name);
	jsonTable = jsonTable.concat('", "tableSlot": [');
	//console.log(lengthRow-1);
	//console.log(lengthColumn-1);
	for(i = 0; i < lengthRow; i++){
		for(j = 0; j < lengthColumn; j++){
			jsonTable = jsonTable.concat(' { "row":"');
			jsonTable = jsonTable.concat(i+1);
			jsonTable = jsonTable.concat('", "column":"');
			jsonTable = jsonTable.concat(j+1);
			jsonTable = jsonTable.concat('", "data":"');
			jsonTable = jsonTable.concat(data[i][j]);
			jsonTable = jsonTable.concat('" }');
			//console.log(i);
			//console.log(j);
			//console.log((lengthRow-1)*(lengthColumn-1));
			if(i*j != (lengthRow-1)*(lengthColumn-1)){
				jsonTable = jsonTable.concat(',');
			}
		}
	}
	jsonTable = jsonTable.concat(' ] }');
	return jsonTable;
}

 function loadJSON(callback) {   

    var xobj = new XMLHttpRequest();
	
        xobj.overrideMimeType("application/json");
    xobj.open('GET', 'json/planData.json', true); // Replace 'my_data' with the path to your file
    xobj.onreadystatechange = function () {
          if (xobj.readyState == 4 && xobj.status == "200") {
            // Required use of an anonymous callback as .open will NOT return a value but simply returns undefined in asynchronous mode
            callback(xobj.responseText);
         }
   };
   xobj.setRequestHeader("Cache-Control", "max-age=0");
   xobj.send(null);  
}


function fillTableFromInput(table, row, column, ID){
	//console.log("fillTable sees");
	var i, j, repeat = 0;
	var index1, index2;
	var data;
	for(i = 1; i <= row; i++){
		for(j = 1; j <= column; j++){
			//console.log(k);
			//console.log(ID.concat('-').concat(i).concat('-').concat(j));
			//console.log(repeat);
			repeat = table.indexOf('<td', repeat);
			index1 = table.indexOf('>', repeat) + 1;
			index2 = table.indexOf('</td>');
			repeat = index2 + 5;
			data = table.substring(index1, index2);
			//console.log(data);
			//console.log(repeat);
			table = table.substring(repeat-1);
			document.getElementById(ID.concat('-').concat(i).concat('-').concat(j)).innerHTML = data;
			repeat = 0;
		}
	}
}

function fillTableFromJSON(data, row, column, ID, table){
	console.log(ID);
	var i, j;
	var tableSlotNum;
	var tableRow;
	var tableColumn;
	var tableSlotData;
	var slot;
	for(i = 0; i < row; i++){
		tableSlotNum = column * i;
		for(j = 0; j < column; j++){
			slot = data.table[table].tableSlot[tableSlotNum+j];
			tableRow = slot.row;
			tableColumn = slot.column;
			tableSlotData = slot.data;
			document.getElementById(ID.concat('-').concat(i+1).concat('-').concat(j+1)).innerHTML = tableSlotData;
		}
	}
}

function getInputFile(input){
	//console.log("kutsuti välja");
	//console.log(input);
	var i;
	var reader = new FileReader();
	reader.readAsArrayBuffer(input.target.files[0]);
	reader.onload = function(input) {
                        var data = new Uint8Array(reader.result);
                        var wb = XLSX.read(data,{type:'array'});
						//console.log(wb.SheetNames[0]);
						var numOfSheets = wb.SheetNames.length;
						newProject('tab');
						for(i = 0; i < numOfSheets; i++){
							var sheetName = wb.SheetNames[i];
							var htmlstr = XLSX.write(wb,{sheet:sheetName, type:'string',bookType:'html'});
							addTab(sheetName, 'tabs');
							var sheetID = 'table'.concat(sheetName);
							showTab(sheetID);
							var trCount = (htmlstr.match(new RegExp("<tr>", "g")) || []).length;
							var tdCount = (htmlstr.match(new RegExp("<td ", "g")) || []).length;
							var columnCount = tdCount / trCount;
							//console.log(trCount);
							//console.log(tdCount);
							//console.log(columnCount);
							generateTable(trCount,columnCount,1);
							fillTableFromInput(htmlstr, trCount, columnCount, sheetID);
							//console.log(htmlstr);
							//document.getElementById('tableRows').innerHTML += htmlstr;
						}
						
						
	}
}

function newProject(tab){
	var tables = document.getElementsByClassName('table');
	var tabs = document.getElementsByClassName(tab);
	var i;
	var tabsName;
	if(tab == "tab"){
		tabsName = "tabs";
	} else {
		tabsName = "tabs2";
	}
	//tableLength = tables.length;
	tableLength = tabs.length;
	//console.log("loop start");
	for(i = tableLength-1; i >= 0; i--){
		//console.log(i);
		document.getElementById('tableRows').removeChild(tables[i]);
		document.getElementById(tabsName).removeChild(tabs[i]);
	}
}

function generateTemplateTable(){
	newProject('tab');
	addTab('Configuration', 'tabs');
	showTab('tableConfiguration');
	generateTable(31,4,1);
	addTab('Timeslot', 'tabs');
	showTab('tableTimeslot');
	generateTable(6,5,1);
	addTab('Author', 'tabs');
	showTab('tableAuthor');
	generateTable(7,15,2);
	addTab('Supervisor', 'tabs');
	showTab('tableSupervisor');
	generateTable(7,14,2);
	addTab('Commitee', 'tabs');
	showTab('tableCommitee');
	generateTable(7,15,2);
	addTab('Defense', 'tabs');
	showTab('tableDefense');
	generateTable(6,9,1);
	
	generateConfigurationTable();
	generateTimeslotTableTemplate();
	generateAuthorTableTemplate();
	generateSupervisorTableTemplate();
	generateCommiteeTableTemplate();
	generateDefenseTableTemplate();
	
}

function generateExampleTable(){
	console.log("here");
	newProject('tab');
	addTab('Configuration', 'tabs');
	showTab('tableConfiguration');
	generateTable(31,4,1);
	addTab('Timeslot', 'tabs');
	showTab('tableTimeslot');
	generateTable(15,5,1);
	addTab('Author', 'tabs');
	showTab('tableAuthor');
	generateTable(10,18,2);
	addTab('Supervisor', 'tabs');
	showTab('tableSupervisor');
	generateTable(11,17,2);
	addTab('Commitee', 'tabs');
	showTab('tableCommitee');
	generateTable(7,18,2);
	addTab('Defense', 'tabs');
	showTab('tableDefense');
	generateTable(9,9,1);
	
	generateConfigurationTable();
	generateTimeslotTable();
	generateAuthorTable();
	generateSupervisorTable();
	generateCommiteeTable();
	generateDefenseTable();
	
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

function addRow(){
	var i;
	var getActiveTable = document.getElementById(activeTable);
	var tbody = getActiveTable.childNodes;
	var tr = document.createElement('tr');
	console.log(document.getElementsByClassName("tableexport-caption").length);
	if(document.getElementsByClassName("tableexport-caption").length == 0){
		var columns = tbody[0].childNodes[0].childNodes.length;
		var rows = tbody[1].childNodes.length + 2;
	} else {
		var columns = tbody[1].childNodes[0].childNodes.length;
		var rows = tbody[2].childNodes.length + 2;
	}
	
	/*console.log(activeTable);
	console.log(tbody.length);
	console.log(columns);
	console.log(rows);*/
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
}

function saveProject(){
	/*var exportData = TableExport(document.getElementsByTagName("table"));
	TableExport.prototype.defaultFilename = "myDownload";
	exportData;
	*/
	//var exportData = new TableExport(document.getElementsByTagName("table"));
	var exportData = new TableExport(document.getElementsByTagName("table"), {
	  headers: true,                      // (Boolean), display table headers (th or td elements) in the <thead>, (default: true)
	  footers: true,                      // (Boolean), display table footers (th or td elements) in the <tfoot>, (default: false)
	  formats: ["xlsx"],    // (String[]), filetype(s) for the export, (default: ['xlsx', 'csv', 'txt'])
	  filename: "id",                     // (id, String), filename for the downloaded file, (default: 'id')
	  bootstrap: false,                   // (Boolean), style buttons using bootstrap, (default: true)
	  exportButtons: true,                // (Boolean), automatically generate the built-in export buttons for each of the specified formats (default: true)
	  position: "top",                 // (top, bottom), position of the caption element relative to table, (default: 'bottom')
	  ignoreRows: null,                   // (Number, Number[]), row indices to exclude from the exported file(s) (default: null)
	  ignoreCols: null,                   // (Number, Number[]), column indices to exclude from the exported file(s) (default: null)
	  trimWhitespace: true,               // (Boolean), remove all leading/trailing newlines, spaces, and tabs from cell text in the exported file(s) (default: false)
	  RTL: false,                         // (Boolean), set direction of the worksheet to right-to-left (default: false)
	  sheetname: "id"                     // (id, String), sheet name for the exported spreadsheet, (default: 'id')
	});
	//TableExport.prototype.defaultFilename = "myDownload";
	//var exportData = TableExport(document.getElementsByTagName("table"));
	console.log("tegi midagi");
}

function s2ab(s){
	var buf = new ArrayBuffer(s.length);
	var view = new Uint8Array(buf);
	for(var i=0; i<s.length; i++){
		view[i] = s.charCodeAt(i) & 0xFF;
	}
	return buf;
}

function getTableData(name){
	var i, j;
	var tableRow = [];
	var table = [];
	var data = document.getElementById(name).childNodes[0].childNodes[0].childNodes[0].innerHTML;
	var tableLength = document.getElementById(name).childNodes[0].childNodes[0].childNodes.length;
	var rowLength1 = document.getElementById(name).childNodes[0].childNodes.length;
	var rowLength2 = document.getElementById(name).childNodes[1].childNodes.length;
	var rowLength = rowLength1 + rowLength2;
	for(i = 0; i < rowLength; i++){
		for(j = 0; j < tableLength; j++){
			if(i < rowLength1){
				data = document.getElementById(name).childNodes[0].childNodes[i].childNodes[j].innerHTML;
			} else if(i <= rowLength2){
				data = document.getElementById(name).childNodes[1].childNodes[i-1].childNodes[j].innerHTML;
			}
			tableRow.push(data);
		}
		table.push(tableRow);
		tableRow = [];
	}
	return table;
}

function saveSheetJSProject(){
	var i;
	var wb = XLSX.utils.book_new();
	wb.Props = {
	Title: "Example Excel",
	Subject: "Test file",
	Author: "Roald Välja",
	CreatedDate: new Date(2020,01,10)
	};
	var tableName = document.getElementsByClassName("table");
	for(i = 0; i < tableName.length; i++){
		wb.SheetNames.push(tableName[i].id.substring(5));
		var ws_data = getTableData(tableName[i].id);
		var ws = XLSX.utils.aoa_to_sheet(ws_data);
		wb.Sheets[tableName[i].id.substring(5)] = ws;
	}
	var wbout = XLSX.write(wb, {bookType:'xlsx', type:'binary'});
	saveAs(new Blob([s2ab(wbout)],{type:"application/octet-stream"}), 'test.xlsx');
}

function showTab(table){
	var tables = document.getElementsByClassName('table');
	var i;
	for(i = 0; i < tables.length; i++){
		tables[i].style.display = "none";
	}
	document.getElementById(table).style.display = "block";
	activeTable = table;
}

function addTab(tabName, tabArea){
	var tabClickHandler = function(arg){
		return function() {showTab(arg);};
	}
	getTab = document.getElementsByName('tabName');
	var tab = document.createElement('div');
	if(tabArea == "tabs2"){
		tab.className = "tab2"
	} else {
		tab.className = "tab";
	}
	if(tabName == ""){
		tabValue = getTab[0].value;
	} else {
		tabValue = tabName;
	}
	tableId = 'table'.concat(tabValue);
	tab.id = tabValue;
	tab.innerHTML = tabValue;
	tab.contentEditable = "true";
	//tab.style.float = "left";
	//tab.style.width = "5%";
	//tab.style.height = "100%";
	//tab.style.backgroundColor = "blue";
	tab.onclick = tabClickHandler(tableId);
	document.getElementById(tabArea).appendChild(tab);
	
	var table = document.createElement('table');
	table.className = "table";
	table.id = tableId;
	table.style.display = "none";
	document.getElementById('tableRows').appendChild(table);
	
	getTab[0].value = "";
}