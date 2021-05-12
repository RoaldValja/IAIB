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

function getTableDataOld(name){
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

function getTableData(name){
	var i, j;
	var tableRow = [];
	var table = [];
	var data = document.getElementById(name).childNodes[0].childNodes[0].childNodes[0].innerHTML;
	var tableLength = document.getElementById(name).childNodes[0].childNodes[0].childNodes.length;
	var rowLength = document.getElementById(name).childNodes[0].childNodes.length;
	//var rowLength2 = document.getElementById(name).childNodes[1].childNodes.length;
	//var rowLength = rowLength1;
	for(i = 0; i < rowLength; i++){
		for(j = 0; j < tableLength; j++){
			if(i < rowLength){
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

var activeTab = "";

function refillActiveTab(){
	tabsArray = [];
	var tabs = document.getElementsByClassName('tab');
	for(i = 0; i < tabs.length; i++){
		tabsArray.push(tabs[i].id.substring(3,4).toLowerCase() + tabs[i].id.substring(4));
		console.log(tabs[i].id.substring(3,4).toLowerCase() + tabs[i].id.substring(4));
	}
}

function deleteTable(table){
	var deletableTable = document.getElementById(table);
	deletableTable.remove();
}

function deleteTab(){
	var tab = document.getElementById(activeTab);
	tab.remove();
	var toRemoveTable = activeTab.substring(0, 3) + "le" + activeTab.substring(3);
	console.log("toRemoveTable on : " + toRemoveTable);
	deleteTable(toRemoveTable);
	refillActiveTab();
	var firstTab = document.getElementsByClassName('tab')[0].id;
	var table = firstTab.substring(0, 3) + "le" + firstTab.substring(3);
	console.log("Siin on deletetab table: " + table);
	showTab(table);
}

function showTab(table){
	console.log("Siin on showTab table: " + table);
	var tables = document.getElementsByClassName('table');
	var i;
	for(i = 0; i < tables.length; i++){
		tables[i].style.display = "none";
	}
	document.getElementById(table).style.display = "block";
	activeTable = table;
	
	var tabs = document.getElementsByClassName('tab');
	var j;
	for(j = 0; j < tabs.length; j++){
		tabs[j].style.backgroundColor = null;
	}
	activeTab = "tab" + table.substring(5,6).toUpperCase() + table.substring(6);
	console.log("Siin on activeTab showtabis: " + activeTab);
	document.getElementById(activeTab).style.backgroundColor = "#c3c7c9";
}

var tabsArray = [];

function addTab(tabName, tabArea){
	var tabValue, i;
	var getTab = document.getElementsByName('tabName');
	console.log("tabs arrays on: " + tabsArray.length);
	if(tabName == ""){
		tabValue = getTab[0].value;
	} else {
		tabValue = tabName;
	}
	if(tabValue.length == 0){
		errorMessage('Ei saa lisada lipikut, kui pole talle antud nime!', "addTab");
	} else if (tabsArray.includes(tabValue)){
		errorMessage('Ei saa panna lipiku nimeks, kuna selle nimeline lipik on juba olemas!', "addTab");
	} else {
		var tabClickHandler = function(arg){
			return function() {showTab(arg);};
		}
		refillActiveTab();
		tabsArray.push(tabValue);
		
		var tab = document.createElement('div');
		if(tabArea == "tabs2"){
			tab.className = "tab2"
		} else {
			tab.className = "tab";
		}
		
		tableId = 'table' + tabValue.substring(0, 1).toUpperCase() + tabValue.substring(1);
		tab.id = "tab" + tabValue.substring(0, 1).toUpperCase() + tabValue.substring(1);
		tab.innerHTML = tabValue;
		tab.contentEditable = "false";
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
		showTab(tableId);
	}	
}

function languageDropdown(){
	console.log(document.getElementById("roaldDropdown"));
	document.getElementById("roaldDropdown").classList.toggle("show");
}

function helpTutorial(){
	document.getElementById("helpMenu").classList.toggle("show");
	var rect = document.getElementById("helpMenu");
	var rect2 = rect.getBoundingClientRect();
	console.log(rect2.top, rect2.right, rect2.bottom, rect2.left);
}

var tutorialTextArrayEstonian = {
	inputFile: "'Sisendfail' nupu ala on ära värvitud punase värviga. Projekti sisendfaili valimiseks vajutage nupule nimega 'Vali fail' ning otsige üles oma tabelite fail. Lubatud failid on Exceli failid või LibreOffice versiooni Calc failid. Nende failide lühendid on: .xlsx, .xls, .ods",
	newProject: "'Loo uus projekt' nupp kustutab kõik endised tabelid ja lipikud ära vanas projektis. Kui täidad nupu kohal oleva 'Projekti nimi' lahtri, siis vajutades 'Salvesta tabel' nupp loob Exceli faili, mille nime on 'Projekti nimi' lahtrist võetud nimi.",
	generateExampleTable: "'Loo näidistabelid' nupp kustutab kõik endised tabelid ja lipikud ära vanas projektis ning selle asemel loob uued tabelid ja lipikud, kus on olemas projekti jaoks sobilikud näidisandmed. Kasuta seda nuppu selleks, et teada mis struktuuriga ja missugused andmed on sobilikud planeerija jaoks.",
	generateTemplateTable: "'Loo tabelite mallid' nupp kustutab kõik endised tabelid ja lipikud ära vanas projektis ning selle asemel loob uued tabelid ja lipikud, kus on olemas ainult projekti jaoks sobilikud veeru nimed ning paar tühja rida. Kasuta seda nuppu selleks, et lihtsalt genereerida endale valmis planeerijaks sobilik mall.",
	addRow: "'Lisa rida' nupp loob all olevale aktiivsele tabelile juurde uue rea. Kui tahad lisada korraga rohkem kui 1 rida, siis kirjuta 'lisa rida' nupust vasakule olevalt vasakpoolsele lahtrisse number, mitu rida tahad lisada ning vajuta 'lisa rida' nuppu. Kui tahad lisada ridu tabelile konkreetse rea alla, siis vajuta selle lahtri peale, mille alla tahad lisada ridu ning vajuta nuppu 'lisa rida'. Kui tahad lisada ridu tabeli lõppu, siis vajuta kusagile tabeli alal olevale tühjale ruumile või veebiliidese hallile taustale. Selleks, et teada milline lahter on aktiivseks tehtud, vaata kas tabelil on mingi lahter ära värvitud beežika värviga.",
	addColumn: "'Lisa veerg' nupp loob all olevale aktiivsele tabelile juurde uue veeru. Kui tahad lisada korraga rohkem kui 1 veerg, siis kirjuta 'lisa rida' nupust vasakule olevalt parempoolsele lahtrisse number, mitu rida tahad lisada ning vajuta 'lisa veerg' nuppu. Kui tahad lisada veerge tabelile konkreetse veeru taha, siis vajuta selle lahtri peale, mille paremale poolele tahad lisada veerge ning vajuta nuppu 'lisa veerg'. Kui tahad lisada veerge tabeli lõppu, siis vajuta kusagile tabeli alal olevale tühjale ruumile või veebiliidese hallile taustale. Selleks, et teada milline lahter on aktiivseks tehtud, vaata kas tabelil on mingi lahter ära värvitud beežika värviga. Ainult kasuta seda nuppu, kui tabelile on vaja juurde lisada uusi kellaaegasid.",
	deleteRow: "'Kustuta rida' nupp kustutab aktiivseks tehtud lahtri rea. Aktiveeritud lahtri värv on beežikas. Nupp töötab ainult siis, kui on tehtud mingisugune tabeli lahter aktiivseks.",
	deleteColumn: "'Kustuta veerg' nupp kustutab aktiivseks tehtud lahtri veeru. Aktiveeritud lahtri värv on beežikas. Nupp töötab ainult siis, kui on tehtud mingisugune tabeli lahter aktiivseks.",
	addTable: "'Lisa tabel' nupp kustutab aktiive tabeli ära ning loob selle asemele uue tabeli. Tabeli ridade arvu valimiseks kirjuta 'lisa rida' nupust vasakule olevale vasakpoolsele lahtrisse number ning veergude arvu valimiseks kirjuta 'lisa rida' nupust vasakule olevale parempoolsele lahtrisse number. Nupp töötab ainult siis, kui oled kirjutanud tabeli rea ja veeru numbrid.",
	addTab: "'Lisa lipik' nupp lisab uue tabeli lipiku, kus saab luua uue tabeli. Lipikud asuvad veebiliideses alloleval äärel.",
	deleteTab: "'Kustuta lipik' nupp kustutab aktiivse tabeli ning selle lipiku ära.",
	saveProject: "'Salvesta tabel' nupp loob uue Exceli faili ja võtab nimeks 'Projekti nimi' lahtrist nime või kasutab programmi poolt valitud nime.",
	planProject: "'Planeeri tabel' nupp võtab veebiliideses olevad tabelite andmed ning saadab selle planeerijasse. Planeerija kirjutab saadud tulemused tagasi veebiliidesesse, lisades veebiliidesesse uued lipikud ja nende tabelid. Planeeritud lipikud asuvad veebiliideses all oleval ribal paremal pool.",
	errorMessageArea: "'Veateated' alal lisatakse uusi veateateid igakord kui kasutaja teeb midagi valesti. Veateated kirjeldavad probleemi lahti ning kui nende peale vajutada, siis värvitakse ära ala või nupp, kus oli tehtud viga. Olemasolevaid veateateid saab ära kustutada vajutades veateatel üleval paremal olevale ristile."
}

var tutorialTextArrayEnglish = {
	inputFile: "'Input file' button allows you to import a table file. The button allows you to import Excel files or LibreOffice Calc files. Those files suffixes are: .xlsx, .xls, .ods",
	newProject: "'Create new project' button deletes all of the current tables and tabs from the project. If you fill in 'Project name', then when you press 'Save table' button, the added project name will be put as the save files name.",
	generateExampleTable: "'Create example table' button deletes all of the current tables and tabs from the project and replaces them with new tables and tabs, that already contain sufficient sample data. Use this button to get to know the structure and what kinds of data are sufficient for the planner.",
	generateTemplateTable: "'Create table templates' button deletes all of the current tables and tabs from the project and replaces them with new tables and tabs, that contain only the sufficient column names and a few empty rows. Use this button to generate a sufficient template for your project.",
	addRow: "'Add row' button creates a new row into the currently active table. If you want to add more than 1 row, you must fill out the 'table row' field to the left of the 'Add row' button. If you want to add rows after a specific row, then you have to activate the above row and then press 'add row' button. If you want to add rows to the end of the table, then deactivate your current active slot by clicking on the empty table field or by clicking anywhere on the gray background area.",
	addColumn: "'Add column' button creates a new column into the currently active table. If you want to add more than 1 row, you must fill out the 'table column' field to the left of the 'Add row' button. If you want to add columns after a specific column, then you have to activate the left column and then press 'add column' button. If you want to add columns to the end of the table, then deactivate your current active slot by clicking on the empty table field or by clicking anywhere on the gray background area.",
	deleteRow: "'Delete row' button deletes the current active row. Activated slots color is beige. The button only works when you have activated a table slot.",
	deleteColumn: "'Delete column' button deletes the current active column. Activated slots color is beige. The button only works when you have activated a table slot.",
	addTable: "'Add table' button deletes the current active table and creates a new one to replace it. To give the table a certain amount of rows, fill out the 'Table row' field and to give the table a certain amount of columns, fill out the 'Table column' field. The button only works when you have writted row and column numbers in their fields.",
	addTab: "'Add tab' button adds a new tab where you can create a new table. Tabs are located at the bottom row of the screen.",
	deleteTab: "'Delete tab' button deletes the current active table and its tab.",
	saveProject: "'Save table' button creates a new Excel file and gives its name from the field 'Project file' or if you havent filled out the field, then it gives the file the programs chosen name.",
	planProject: "'Plan table' button takes the data from the project tables and sends them to the planner. Planner then writes new tables for the project by adding new tables and tabs and filling them out with planned data. Planned tabs are located at the bottom of the screen on the right side.",
	errorMessageArea: "'Error messages' area gets added new error messages everytime the user makes any mistakes. Error messages describe the problem and if you click on them, then it will highlight where you made the mistake. The existing error messages can be dismissed by clicking on the small X at the top right corner of the error message."
}

var tutorialTextKeysArray = ["inputFile", "newProject", "generateExampleTable", "generateTemplateTable", "addRow", "addColumn", "deleteRow", "deleteColumn", "addTable", "addTab", "deleteTab", "saveProject", "planProject", "errorMessageArea"];

var lastTutorialButton = "";
var lastTutorialHelpButton = "";
var tutorialPosition = 0;

function getTutorial(id, position){
	var menuButton = document.getElementById(id);
	console.log("get tutoriali sees");
	console.log("id on: " + id);
	console.log("position on: " + position);
	menuButton.style.backgroundColor = "#c3e4f7";
	
	var helpButtonId = "tutorial" + id.substring(0, 1).toUpperCase() + id.substring(1);
	var helpButton = document.getElementById(helpButtonId);
	helpButton.style.backgroundColor = "#d8dfe3";
	
	if(lastTutorialButton != "" && lastTutorialButton != id){
		document.getElementById(lastTutorialButton).style.backgroundColor = null;
		document.getElementById(lastTutorialHelpButton).style.backgroundColor = null;
	}
	if(chosenLanguage == "Estonian"){
		var tutorialText = tutorialTextArrayEstonian[id];
	} else if(chosenLanguage == "English"){
		var tutorialText = tutorialTextArrayEnglish[id];
	}
	
	console.log(tutorialText);
	document.getElementById("tutorialText").innerHTML = tutorialText;
	lastTutorialButton = id;
	lastTutorialHelpButton = helpButtonId;
	tutorialPosition = position;
}

function getTutorial2(command){
	console.log("Kindel positioon on: " + tutorialPosition);
	var id;
	var newPosition;
	var intTutorialPosition = parseInt(tutorialPosition);
	if(command == "next"){
		if(intTutorialPosition == tutorialTextKeysArray.length-1){
			newPosition = 0;
		} else {
			newPosition = intTutorialPosition + 1;
		}
		id = tutorialTextKeysArray[newPosition];
		getTutorial(id, newPosition);
	} else if(command == "last"){
		if(intTutorialPosition == 0){
			newPosition = tutorialTextKeysArray.length - 1;
		} else {
			newPosition = intTutorialPosition - 1;
		}
		id = tutorialTextKeysArray[newPosition];
		getTutorial(id, newPosition);
	}
}

function closeTutorial(){
	document.getElementById("helpMenu").classList.toggle("show");
	if(lastTutorialButton != ""){
		document.getElementById(lastTutorialButton).style.backgroundColor = null;
	}
	document.getElementById("tutorialText").innerHTML = "";
	lastTutorialButton = "";
}

var chosenLanguage = "Estonian";

function languageChoice(language){
	console.log(language);
	if(language == "Estonian"){
		chosenLanguage = "Estonian";
		document.getElementById("spanLanguage").innerHTML = "Keel";
		//document.getElementById("spanLanguage").style.fontSize = "100%";
		document.getElementById("spanHelp").innerHTML = "Abi";
		document.getElementById("spanPlanProject").innerHTML = "Planeeri tabel";
		document.getElementById("spanSaveProject").innerHTML = "Salvesta tabel";
		document.getElementById("spanDeleteTab").innerHTML = "Kustuta lipik";
		document.getElementById("spanAddTab").innerHTML = "Lisa lipik";
		document.getElementById("spanAddTable").innerHTML = "Lisa tabel";
		document.getElementById("spanDeleteColumn").innerHTML = "Kustuta veerg";
		document.getElementById("spanDeleteRow").innerHTML = "Kustuta rida";
		document.getElementById("spanAddColumn").innerHTML = "Lisa veerg";
		//document.getElementById("spanAddColumn").style.fontSize = "100%";
		document.getElementById("spanAddRow").innerHTML = "Lisa rida";
		
		document.getElementById("tabName").placeholder = "Tabeli nimi";
		document.getElementById("tableColumn").placeholder = "Tabeli veerg";
		//document.getElementById("tableColumn").style.fontSize = "75%";
		document.getElementById("tableRow").placeholder = "Tabeli rida";
		
		document.getElementById("spanCreateNewProject").innerHTML = "Loo uus projekt";
		document.getElementById("spanCreateNewProject").style.top = "30%";
		document.getElementById("spanCreateExampleTables").innerHTML = "Loo näidistabelid";
		document.getElementById("spanCreateExampleTables").style.top = "30%";
		document.getElementById("spanCreateTableTemplates").innerHTML = "Loo tabelite mallid";
		
		document.getElementById("spanProjectName").innerHTML = "Projekti nimi:";
		document.getElementById("inputProjectName").placeholder = "Projekti nimi";
		
		document.getElementById("spanInputFile").innerHTML = "Sisendfail";
		
		document.getElementById("spanErrorMessages").innerHTML = "Veateated";
		document.getElementById("spanPlanningTables").innerHTML = "Planeeritavad tabelid";
		document.getElementById("spanPlanningTables").style.top = "15%";
		document.getElementById("spanPlannedTables").innerHTML = "Planeeritud tabelid";
		document.getElementById("spanPlannedTables").style.top = "15%";
		
		document.getElementById("buttonEmptyArea2").style.width = "4%";
		document.getElementById("tableEditing").style.width = "35%";
		document.getElementById("buttonEmptyArea3").style.width = "3%";
		document.getElementById("endingArea").style.width = "20%";
		document.getElementById("finishingButtonsFrontArea").style.width = "79.6%";
		document.getElementById("finishingButtonsBackArea").style.width = "19.6%";
		
		document.getElementById("helpMenu").style.right = null;
		document.getElementById("helpMenu").style.width = null;
		
		document.getElementById("tutorialInputFile").innerHTML = "Sisendfail";
		document.getElementById("tutorialNewProject").innerHTML = "Loo uus projekt";
		document.getElementById("tutorialGenerateExampleTable").innerHTML = "Loo näidistabelid";
		document.getElementById("tutorialGenerateTemplateTable").innerHTML = "Loo tabelite mallid";
		document.getElementById("tutorialAddRow").innerHTML = "Lisa rida";
		document.getElementById("tutorialAddColumn").innerHTML = "Lisa veerg";
		document.getElementById("tutorialDeleteRow").innerHTML = "Kustuta rida";
		document.getElementById("tutorialDeleteColumn").innerHTML = "Kustuta veerg";
		document.getElementById("tutorialAddTable").innerHTML = "Lisa tabel";
		document.getElementById("tutorialAddTab").innerHTML = "Lisa lipik";
		document.getElementById("tutorialDeleteTab").innerHTML = "Kustuta lipik";
		document.getElementById("tutorialSaveProject").innerHTML = "Salvesta tabel";
		document.getElementById("tutorialPlanProject").innerHTML = "Planeeri tabel";
		document.getElementById("tutorialErrorMessageArea").innerHTML = "Veateated";
		document.getElementById("tutorialNext").innerHTML = "Järgmine";
		document.getElementById("tutorialPrevious").innerHTML = "Eelmine";
		
	} else if (language == "English"){
		chosenLanguage = "English";
		document.getElementById("spanLanguage").innerHTML = "Language";
		//document.getElementById("spanLanguage").style.fontSize = "90%";
		document.getElementById("spanHelp").innerHTML = "Help";
		document.getElementById("spanPlanProject").innerHTML = "Plan table";
		document.getElementById("spanSaveProject").innerHTML = "Save table";
		document.getElementById("spanDeleteTab").innerHTML = "Delete tab";
		document.getElementById("spanAddTab").innerHTML = "Add tab";
		document.getElementById("spanAddTable").innerHTML = "Add table";
		document.getElementById("spanDeleteColumn").innerHTML = "Delete column";
		document.getElementById("spanDeleteRow").innerHTML = "Delete row";
		document.getElementById("spanAddColumn").innerHTML = "Add column";
		//document.getElementById("spanAddColumn").style.fontSize = "90%";
		document.getElementById("spanAddRow").innerHTML = "Add row";
		
		document.getElementById("tabName").placeholder = "Table name";
		document.getElementById("tableColumn").placeholder = "Table column";
		//document.getElementById("tableColumn").style.fontSize = "70%";
		document.getElementById("tableRow").placeholder = "Table row";
		
		document.getElementById("spanCreateNewProject").innerHTML = "Create new project";
		document.getElementById("spanCreateNewProject").style.top = "15%";
		document.getElementById("spanCreateExampleTables").innerHTML = "Create example tables";
		document.getElementById("spanCreateExampleTables").style.top = "15%";
		document.getElementById("spanCreateTableTemplates").innerHTML = "Create table templates";
		
		document.getElementById("spanProjectName").innerHTML = "Project name:";
		document.getElementById("inputProjectName").placeholder = "Project name";
		
		document.getElementById("spanInputFile").innerHTML = "Input file";
		
		document.getElementById("spanErrorMessages").innerHTML = "Error messages";
		document.getElementById("spanPlanningTables").innerHTML = "Planning tables";
		document.getElementById("spanPlanningTables").style.top = "30%";
		document.getElementById("spanPlannedTables").innerHTML = "Planned tables";
		document.getElementById("spanPlannedTables").style.top = "30%";
		
		document.getElementById("buttonEmptyArea2").style.width = "2%";
		document.getElementById("tableEditing").style.width = "37%";
		document.getElementById("buttonEmptyArea3").style.width = "2%";
		document.getElementById("endingArea").style.width = "21%";
		document.getElementById("finishingButtonsFrontArea").style.width = "74.6%";
		document.getElementById("finishingButtonsBackArea").style.width = "24.6%";
		
		document.getElementById("helpMenu").style.right = "1150%";
		document.getElementById("helpMenu").style.width = "750%";
		
		document.getElementById("tutorialInputFile").innerHTML = "Input file";
		document.getElementById("tutorialNewProject").innerHTML = "Create new project";
		document.getElementById("tutorialGenerateExampleTable").innerHTML = "Create example tables";
		document.getElementById("tutorialGenerateTemplateTable").innerHTML = "Create table templates";
		document.getElementById("tutorialAddRow").innerHTML = "Add row";
		document.getElementById("tutorialAddColumn").innerHTML = "Add column";
		document.getElementById("tutorialDeleteRow").innerHTML = "Delete row";
		document.getElementById("tutorialDeleteColumn").innerHTML = "Delete column";
		document.getElementById("tutorialAddTable").innerHTML = "Add table";
		document.getElementById("tutorialAddTab").innerHTML = "Add tab";
		document.getElementById("tutorialDeleteTab").innerHTML = "Delete tab";
		document.getElementById("tutorialSaveProject").innerHTML = "Save table";
		document.getElementById("tutorialPlanProject").innerHTML = "Plan table";
		document.getElementById("tutorialErrorMessageArea").innerHTML = "Error messages";
		document.getElementById("tutorialNext").innerHTML = "Next";
		document.getElementById("tutorialPrevious").innerHTML = "Previous";
	}
}

var activeTableRow = 0;
var activeTableColumn = 0;
var activeTablePiece = "";
var errorMessageID = 0;
var errorMessageSeperatorID = 1;
var errorMessageTarget = [];
var lastErrorMessage;

function errorMessage(message, target){
	console.log(message);
	var span, i;
	if(lastErrorMessage != message){
		if(errorMessageTarget.includes(target)){
			console.log("See error on juba toimunud!");
			var errorIndex;
			for(i = 0; i < errorMessageTarget.length; i++){
				if(errorMessageTarget[i] == target){
					errorIndex = i;
				}
			}
			document.getElementById("errorMessageNumber-" + errorIndex).remove();
			console.log("erroreid klassis on kokku: " + document.getElementsByClassName("errorMessage").length);
			
			if(document.getElementsByClassName("errorMessage").length > 0){
				document.getElementById("errorMessageSeperator-" + errorMessageSeperatorID).remove();
				errorMessageSeperatorID++;
			}
		}
		
		// childNodes.length > 3 on kuna childnodid leiavad 2 text node, mis on tühjad.
		if(document.getElementById("errorMessageArea").childNodes.length > 3){
			span = document.createElement('span');
			span.className = "errorMessageSeperator";
			span.id = "errorMessageSeperator-" + errorMessageID;
			span.innerHTML = "----------------------";
			document.getElementById("errorMessageArea").appendChild(span);
		}
		
		span = document.createElement('span');
		span.className = "errorMessage";
		span.id = "errorMessageNumber-" + errorMessageID;
		span.innerHTML = message;
		document.getElementById("errorMessageArea").appendChild(span);
		errorMessageID++;
		errorMessageTarget.push(target);
		lastErrorMessage = message;
		flashError();
	}
}

function flashError(){
	var div = document.getElementById("errorMessageHeader");
	console.log("on flasherroris");
	var sum = 0;
	var interval = setInterval(frame, 250);
	function frame(){
		console.log("interval toimub");
		if(sum == 2000){
			clearInterval(interval);
		} else {
			sum = sum + 250;
			if(div.style.backgroundColor == "white"){
				div.style.backgroundColor = "#e67e65";
			} else {
				div.style.backgroundColor = "white";
			}
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
	activeTable = null;
}

function generateTemplateTable(){
	newProject('tab');
	addTab('Configuration', 'tabs');
	showTab('tableConfiguration');
	generateTable(25,4,1);
	addTab('Timeslot', 'tabs');
	showTab('tableTimeslot');
	generateTable(6,6,1);
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
	generateTable(25,4,1);
	addTab('Timeslot', 'tabs');
	showTab('tableTimeslot');
	generateTable(15,6,1);
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
				//var bold = false;
				//console.log(rowId);
				if(i < header){
					//td = document.createElement('th');
					bold = true;
				} else {
					//td = document.createElement('td');
					bold = false;
				}
				td = document.createElement('td');
				td.className = "tableRowClass";
				//td.id = rowId.concat('-', getJ);
				td.id = activeTable.concat('-', rowId,'-', getJ);
				td.innerHTML = rowId.concat('-', getJ);
				td.contentEditable = "true";
				if(i < header){
					td.style.fontWeight = "900";
				}
				tr.appendChild(td);
			}
		tbody.appendChild(tr);
		document.getElementById(activeTable).appendChild(tbody);
		/*if(i == 0){
			thead.appendChild(tr);
			document.getElementById(activeTable).appendChild(thead);
		} else{
			tbody.appendChild(tr);
			document.getElementById(activeTable).appendChild(tbody);
		}*/
	}
	// proov parandada addrow kui ainult 1 rida tabelis
	/*if(row == 1){
		document.getElementById(activeTable).appendChild(tbody);
	}*/
	document.getElementsByName('getTableRow')[0].value = "";
	document.getElementsByName('getTableColumn')[0].value = "";
}



function insertAfterRow(newNode, activeNode){
	activeNode.parentNode.parentNode.insertBefore(newNode, activeNode.parentNode.nextSibling);
	console.log("Siin on grandparent node!");
	console.log(activeNode.parentNode.parentNode);
}
/*
function insertBeforeRow(newNode, activeNode){
	console.log("enne suurt viga");
	console.log(activeNode.parentNode);
	console.log(activeNode.parentNode.parentNode);
	console.log(activeNode.parentNode.parentNode.parentNode);
	console.log(activeNode.parentNode.parentNode.parentNode.childNodes[1]);
	console.log(activeNode.parentNode.parentNode.parentNode.childNodes[1].childNodes[0]);
	console.log(activeNode.parentNode.parentNode.nextSibling);
	console.log(activeNode.parentNode.parentNode.nextSibling.childNodes[0]);
	//activeNode.parentNode.parentNode.insertBefore(newNode, activeNode.parentNode.parentNode.nextSibling.childNodes[0]);
	activeNode.parentNode.parentNode.insertBefore(newNode, activeNode.parentNode.parentNode.parentNode.childNodes[1].childNodes[0]);
	console.log("Siin on grandparent node!");
	console.log(activeNode.parentNode.parentNode);
}
*/
function insertAfterColumn(newNode, activeNode){
	//console.log(activeNode + " ---------------------activenode")
	activeNode.parentNode.insertBefore(newNode, activeNode.nextSibling);
	console.log("Lisati veerg!");
}

function addRow(){
	var tableRowValue = document.getElementById("tableRow").value;
	var newRows = parseInt(tableRowValue, 10);
	if(activeTable == null){
		errorMessage('Ei saa lisada tabeli rida tabelisse, mida pole olemas!', "addRow");
	}
	else if(Number.isInteger(newRows) || tableRowValue == ""){
		var i, j;
		var getActiveTable = document.getElementById(activeTable);
		var tbody = getActiveTable.childNodes;
		console.log("Lisame rida");
		console.log(tbody[2]);
		console.log(activeTable);
		
		console.log("siin on rea number!");
		console.log(document.getElementById("tableRow").value);
		
		console.log(parseInt(document.getElementById("tableRow").value, 10));
		
		
		var newRowsMax = 1;
	
		console.log("Sisestati numbriline sisend");
		
		if(tableRowValue != ""){
			newRowsMax = newRows;
		}
		
		for(j = 0; j < newRowsMax; j++){
		
			var tr = document.createElement('tr');
			
			var columns = tbody[0].childNodes[0].childNodes.length;
			var rows = tbody[0].childNodes.length + 1;
			var rowsStr = "";
			
			for(i = 0; i < columns; i++){
				var getI = i+1;
				rowsStr = rows.toString();
				var td = document.createElement('td');
				td.className = "tableRowClass";
				td.id = activeTable.concat('-', rowsStr, '-', getI);
				//td.innerHTML = rowsStr.concat('-', getI);
				td.style.minWidth = "50px";
				//td.style.resize = "both";
				//td.style.wordBreak = "break-all";
				td.contentEditable = "true";
				tr.appendChild(td);
			}
			
			if(activeTableRow == 0 && activeTableColumn == 0){
				console.log("Lisab uue table row");
				tbody[0].appendChild(tr);
			} 
			else if(activeTableRow != 0 && activeTableColumn != 0){
				var rowID = activeTable + "-" + activeTableRow + "-" + activeTableColumn;
				console.log(rowID + " RowID!");
				var rowElement = document.getElementById(rowID);
				console.log(rowElement);
				console.log(rowElement.parentNode);
				insertAfterRow(tr, rowElement);
				console.log("PRAEGUNE TABLE ROW ON : " + activeTableRow);
				correctRows(activeTableRow, activeTableColumn);
			}
		}
		document.getElementById("tableRow").value = "";
	}
	else {
		console.log("Sisestati mittenumbriline sisend");
		errorMessage('Tabeli reaks sisestati "' + tableRowValue + '", mis pole täisarvuline sisend!', "tableRow");	
	}
		
}



function removeRow(){
	if(activeTable == null){
		console.log("----------------------------- tabel pole aktiivne!!!!!!!!!!!!!!!!");
		errorMessage('Ei saa kustutada ridasid tabelist, mida pole olemas!', "deleteRow");	
	} else if(activeTableColumn == 0 && activeTableRow == 0){
		errorMessage('Ei saa kustutada tabeli rida, kui seda pole tehtud aktiivseks!', "deleteRow");
	} else {
		var tableRowId = activeTable + "-" + activeTableRow + "-" + activeTableColumn;
		var activeNode = document.getElementById(tableRowId);
		var previousNode = activeNode.parentNode.previousSibling.childNodes[0];
		console.log(previousNode);
		activeNode.parentNode.remove();
		correctRows(parseInt(activeTableRow) - 1, activeTableColumn);
		activeTablePiece = "";
		activeTableRow = 0;
		activeTableColumn = 0;
	}
}

function addColumn(){
	var tableColumnValue = document.getElementById("tableColumn").value;
	var newColumns = parseInt(tableColumnValue, 10);
	if(activeTable == null){
		errorMessage('Ei saa lisada tabeli veergu tabelisse, mida pole olemas!', "addColumn");
	}
	else if(Number.isInteger(newColumns) || tableColumnValue == ""){
		var i, j, k, activeNode;
		var getActiveTable = document.getElementById(activeTable);
		var tbody = getActiveTable.childNodes;
		var currentRow;
		
		
		var newColumnsMax = 1;
		console.log("Sisestati numbriline sisend");
		
		if(tableColumnValue != ""){
			newColumnsMax = newColumns;
		}
		
		for(k = 0; k < newColumnsMax; k++){
			var th = document.createElement('th');
			var row = "1";
			var column = tbody[0].childNodes[0].childNodes.length + 1;
			var rows = tbody[0].childNodes.length + 1;
			var tdArray = [];
			
			console.log(column);
			/*
			th.className = "tableRowClass";
			th.id = activeTable.concat('-', row, '-', column);
			th.style.minWidth = "50px";
			//th.innerHTML = row.concat('-', column);
			th.contentEditable = "true";
			*/
			var rowsStr;
			
			for(i = 0; i < rows-1; i++){
				getI = i+1;
				rowsStr = getI.toString();
				var td = document.createElement('td');
				td.className = "tableRowClass";
				td.id = activeTable.concat('-', rowsStr, '-', column);
				//td.innerHTML = rowsStr.concat('-', column);
				td.style.minWidth = "50px";
				td.contentEditable = "true";
				tdArray.push(td);
			}
			
			if(activeTableRow == 0 && activeTableColumn == 0){	
				//tbody[0].childNodes[0].appendChild(th);
				
				for(j = 0; j < tdArray.length; j++){
					activeNode = tdArray[j];
					tbody[0].childNodes[j].appendChild(activeNode);
				}
			}
			else if (activeTableRow != 0 && activeTableColumn != 0){
				console.log("on mittenullise active column sees");
				currentRow = 1;
				for(i = 0; i < tdArray.length; i++){
					var rowID = activeTable + "-" + currentRow + "-" + activeTableColumn;
					var rowElement = document.getElementById(rowID);
					//console.log("For loopis " + i);
					//console.log(rowID + " ------------------------------------------rowID");
					/*
					if(i == 0){
						insertAfterColumn(th, rowElement);
					}
					else {
						activeNode = tdArray[i-1];
						console.log(rowElement + " -----------------------rowElement");
						insertAfterColumn(activeNode, rowElement);
					}*/
					activeNode = tdArray[i];
					//console.log(rowElement + " -----------------------rowElement");
					insertAfterColumn(activeNode, rowElement);
					console.log("siin on rowID -------------------------------------- " + rowID);
					correctColumns(currentRow, activeTableColumn);
					currentRow++;
				}
			}
		}
		document.getElementById("tableColumn").value = "";
	}
	else {
		console.log("Sisestati mittenumbriline sisend");
		errorMessage('Tabeli veeruks sisestati "' + tableColumnValue + '", mis pole täisarvuline sisend!', "tableColumn");	
	}
}

function correctRows(currentRow, currentColumn){
	var tableRowID = activeTable + "-" + currentRow + "-" + currentColumn;
	console.log(tableRowID + " ----------------------------------- ROW ID ON");
	var rowLength = document.getElementById(tableRowID).parentNode.childNodes.length;
	var columnLength = document.getElementById(tableRowID).parentNode.parentNode.childNodes.length;
	console.log("Row length on : " + rowLength);
	console.log("Column length on : " + columnLength);
	console.log("current row on : " + currentRow);
	var i, j, getI, currentTableSlotID;
	for(i = currentRow; i < columnLength; i++){
		for(j = 0; j < rowLength; j++){
			console.log("i on :" + i + " ja j on :" + j);
			getJ = parseInt(j)+1;
			getI = parseInt(i) + 1;
			currentTableSlotID = activeTable + "-" + getI + "-" + getJ;
			document.getElementById(tableRowID).parentNode.parentNode.childNodes[i].childNodes[j].id = currentTableSlotID;
		}
	}
}

function correctColumns(currentRow, currentColumn){
	var tableColumnID = activeTable + "-" + currentRow + "-" + currentColumn;
	console.log(tableColumnID + " ---------------------------- ROW ID ON");
	var rowLength = document.getElementById(tableColumnID).parentNode.childNodes.length;
	console.log("row suurus on :" + rowLength);
	var activeColumn = parseInt(currentColumn) + 1;
	var i, currentTableSlotID, temporaryID;
	for(i = activeColumn; i < rowLength+1; i++){
		console.log("i on : " + i);
		currentTableSlotID = activeTable + "-" + currentRow + "-" + i;
		document.getElementById(tableColumnID).parentNode.childNodes[i-1].id = currentTableSlotID;
		//document.getElementById(currentTableSlotID)
	}
	
}

function removeColumn(){
	if(activeTable == null){
		console.log("----------------------------- tabel pole aktiivne!!!!!!!!!!!!!!!!");
		errorMessage('Ei saa kustutada veerge tabelist, mida pole olemas!', "deleteColumn");	
	} else if(activeTableColumn == 0 && activeTableRow == 0){
		errorMessage('Ei saa kustutada tabeli veergu, kui seda pole tehtud aktiivseks!', "deleteColumn");
	} else {
		var currentRow = 1;
		var getActiveTable = document.getElementById(activeTable);
		var tbody = getActiveTable.childNodes;
		var rows = tbody[0].childNodes.length;
		console.log(rows + " on rowlength!");
		var i;
		for(i = 0; i < rows; i++){
			var tableRowId = activeTable + "-" + currentRow + "-" + activeTableColumn;
			console.log(tableRowId);
			var activeNode = document.getElementById(tableRowId);
			activeNode.remove();
			correctColumns(currentRow, parseInt(activeTableColumn) - 1);
			currentRow++;
		}
		
		activeTablePiece = "";
		activeTableRow = 0;
		activeTableColumn = 0;
	}
	
}
/*
	Configuration tabelis vaja kontrollida, et Kaal oleks täisarvuline number. Tal ei tohi olla tähti, komakohta ega erilisi sümboleid.
	Timeslot tabelis peab kontrollima, et kuupäev on kindlas formaadis: dd.mm.yyyy. Kuupäev ei tohi sisaldada tähti ega erilisi sümboleid. 
	Päevade arv ei tohi olla suurem kui 31 ja kuude arv ei tohi olla suurem kui 12.
	Algus formaat peab olema hh:mm. Ei tohi sisaldada tähti, punkti ega erilisi sümboleid peale kooloni. 
	Lõpp formaat peab olema hh:mm. Ei tohi sisaldada tähti, punkti ega erilisi sümboleid peale kooloni.
	Lõpp kellaaeg peab olema suurem kui Algus kellaaeg.
	Kaitsmise tüüp peab olema kas Lahtine, Kinnine (küsida kas suur algustäht on oluline) või tühi. Kui kaitsmise tüüp on tühi, siis sessioon peab olema ka tühi 
	ning üks võtmesõna peab sisaldama vaheaeg.
	Sessioon peab sisaldama ainult numbreid. Ei tohi sisaldada tähti, koma ega punkti ning erilisi sümboleid.
	Võtmesõnadel pole mingeid reegleid.
	Author tabelis peab Eeldused on täidetud veerus olema ainult (Jah, jah, Ei, ei).
	Juhendajad veerus peab sisaldama Juhendaja nime, mis on olemas Supervisor tabelis.
	Märksõnadel pole reegleid.
	Kuupäevad ja kellaajad peavad olema olemas Timeslot tabelis. Nende sisu lahtrites peab olema kas tühi või sisaldama järgmisi sõnu: Ei sobi, Eelistab, Ei eelista.
	Kellaajad peavad sisaldama algust ja lõppu ja eraldama neid sidekriipsuga.
	Supervisor tabelis peab Roll veerus olema kas Peajuhendaja või Kaasjuhendaja.
	Märksõnadel pole reegleid.
	Kuupäevad ja kellaajad on samad reeglid.
	Commitee tabelis on Kraad veerus kas Doktor või Magister.
	Esimees veerus on kas Esimees, Aseesimees või Ei.
	Märksõnadel pole reegleid.
	Kuupäevad ja kellaajad on samad reeglid.
	Defense tabelis Kood peab igal real olema unikaalne. kood nt D000 - D999
	Lõputöö pealkiri ei tohi sisaldada erilisi sümboleid.
	Kaitsmise tüüp peab olema kas Lahtine või Kinnine.
	Lõputöö kraad peab olema Bakalaureus.
	Lõputöö autor peab olema sama nimi, mis on olemas Author tabelis.
	Sarnane lõputöö teema ei tohi sisaldada erilisi sümboleid.
	Ruumi numbril pole reegleid.
	Ruumi maht peab sisaldama ainult täisarvulisi numbreid.
	Komisjoni suurus peab sisaldama ainult täisarvulisi numbreid.
*/



function validate(){
	//if(document.getElementById())
}

function validateGenericSymbols(){
	
}

function validateTimeslot(){
	
}

function validatePairControl(){
	
}

window.onclick = function(event){
	var i;
	if(event.target.closest('#spanKeel')){
		console.log("Vajutas spanKeel peale");
	}
	
	if(event.target.matches('.errorMessage')){
		console.log("Vajutati error message alale");
		var errorID = event.target.id;
		var targetArrayIdIndex = errorID.indexOf("-");
		var targetArrayId = errorID.substring(targetArrayIdIndex+1);
		var errorMessageTargetId = errorMessageTarget[targetArrayId];
		var errorDOM = document.getElementById(errorMessageTargetId);
		console.log(errorDOM);
		for(i = 0; i < errorMessageTarget.length; i++){
			console.log(errorMessageTarget[i] + " on selle errori id");
			document.getElementById(errorMessageTarget[i]).style.backgroundColor = "white";
		}
		errorDOM.style.backgroundColor = "#f07d5d";
	} else {
		console.log(errorMessageTarget.length + " on array suurus");
		for(i = 0; i < errorMessageTarget.length; i++){
			console.log(errorMessageTarget[i] + " on selle errori id");
			document.getElementById(errorMessageTarget[i]).style.backgroundColor = "white";
		}
	}
	/*
	if(!event.target.matches('#helpButton') && !event.target.matches('#helpMenu')){
		var helpMenuFrame = document.getElementsByClassName("helpMenuClass");
		console.log("ta on siin sees!!!!!!!!!!!!!!!");
		for(i = 0; i < helpMenuFrame.length; i++){
			var helpMenu = helpMenuFrame[i];
			console.log("Ta on for loopis!!!!!");
			console.log(i);
			console.log(helpMenu);
			if(helpMenu.classList.contains('show')){
				helpMenu.classList.remove('show');
			}
		}
	}
	*/
	if(!event.target.closest('.menuButtonExtra')) {
		var dropdowns = document.getElementsByClassName("dropdown-content2");
		for(i = 0; i < dropdowns.length; i++){
			var openDropdown = dropdowns[i];
			if(openDropdown.classList.contains('show')){
				openDropdown.classList.remove('show');
			}
		}
		
		if(event.target.matches('#tableRows') || event.target.matches('.tab') || event.target.matches('.emptySpace')){
			console.log("Vajutas tühjale " + event.target.id + " alale");
			activeTableRow = 0;
			activeTableColumn = 0;
			console.log(activeTableRow);
			console.log(activeTableColumn);
			if(activeTablePiece != ""){
				document.getElementById(activeTablePiece).style.backgroundColor = "white";
			}
		}
		
		if(event.target.className.includes("tableRowClass")){
			var tableInfo = event.target.id;
			var rowIndex = tableInfo.indexOf("-");
			var tableInfoBack = tableInfo.substring(rowIndex+1);
			var columnIndex = tableInfoBack.indexOf("-");
			activeTableRow = tableInfoBack.substring(0, columnIndex);
			activeTableColumn = tableInfoBack.substring(columnIndex+1);
			console.log("tabeli tükk on aktiveeritud!");
			console.log(tableInfo);
			console.log(activeTableRow);
			console.log(activeTableColumn);
			if(activeTablePiece != ""){
				document.getElementById(activeTablePiece).style.backgroundColor = "white";
			}
			document.getElementById(tableInfo).style.backgroundColor = "#e6d8c3";
			activeTablePiece = tableInfo;
		}
		
	}
}