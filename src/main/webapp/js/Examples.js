function generateConfigurationTable(){
	document.getElementById('tableConfiguration-1-1').innerHTML = "Kitsendus";
	document.getElementById('tableConfiguration-1-2').innerHTML = "Kaal";
	document.getElementById('tableConfiguration-1-3').innerHTML = "Kirjeldus";
	document.getElementById('tableConfiguration-1-4').innerHTML = "Tüüp";
	document.getElementById('tableConfiguration-2-1').innerHTML = "Defense timeslot only for single author";
	document.getElementById('tableConfiguration-2-2').childNodes[0].value = "1000";
	document.getElementById('tableConfiguration-2-3').innerHTML = "Kaitsmisel on autoril ainult üks kaitsmise aeg";
	document.getElementById('tableConfiguration-2-4').innerHTML = "Hard";
	document.getElementById('tableConfiguration-3-1').innerHTML = "Defense authors grouped by common supervisor";
	document.getElementById('tableConfiguration-3-2').childNodes[0].value = "50";
	document.getElementById('tableConfiguration-3-3').innerHTML = "Kui ühel juhendajal on mitu juhendatavat, siis nende kaitsmised grupeeritakse kokku";
	document.getElementById('tableConfiguration-3-4').innerHTML = "Soft";
	document.getElementById('tableConfiguration-4-1').innerHTML = "Defense timeslots grouped by common session and have no holes between them";
	document.getElementById('tableConfiguration-4-2').childNodes[0].value = "40";
	document.getElementById('tableConfiguration-4-3').innerHTML = "Kaitsmise ajad on grupeeritud sarnase sessiooni järgi ja nende vahel pole tühjasid aegasid";
	document.getElementById('tableConfiguration-4-4').innerHTML = "Soft";
	document.getElementById('tableConfiguration-5-1').innerHTML = "Commission member does not swap with a new member in the same session";
	document.getElementById('tableConfiguration-5-2').childNodes[0].value = "25";
	document.getElementById('tableConfiguration-5-3').innerHTML = "Kaitsmisel komisjoni liige ei vaheta oma kohta uue liikmega samal sessioonil";
	document.getElementById('tableConfiguration-5-4').innerHTML = "Soft";
	document.getElementById('tableConfiguration-6-1').innerHTML = "Defense not on authors unavailable timeslot";
	document.getElementById('tableConfiguration-6-2').childNodes[0].value = "10";
	document.getElementById('tableConfiguration-6-3').innerHTML = "Kaitsmine ei toimu lõputöö kaitsja sobimatul kuupäeva kellaajal";
	document.getElementById('tableConfiguration-6-4').innerHTML = "Hard";
	document.getElementById('tableConfiguration-7-1').innerHTML = "Defense on authors preferred timeslot";
	document.getElementById('tableConfiguration-7-2').childNodes[0].value = "15";
	document.getElementById('tableConfiguration-7-3').innerHTML = "Kaitsmine toimub lõputöö kaitsja eelistatud kuupäeva kellaajal";
	document.getElementById('tableConfiguration-7-4').innerHTML = "Soft";
	document.getElementById('tableConfiguration-8-1').innerHTML = "Defense not on authors not preferred timeslot";
	document.getElementById('tableConfiguration-8-2').childNodes[0].value = "10";
	document.getElementById('tableConfiguration-8-3').innerHTML = "Kaitsmine ei toimu lõputöö kaitsja mitte-eelistatud kuupäeva kellaajal";
	document.getElementById('tableConfiguration-8-4').innerHTML = "Soft";
	document.getElementById('tableConfiguration-9-1').innerHTML = "Defense not on authors unavailable timeslot tag";
	document.getElementById('tableConfiguration-9-2').childNodes[0].value = "10";
	document.getElementById('tableConfiguration-9-3').innerHTML = "Kaitsmine ei toimu lõputöö kaitsja sobimatul aja märksõnal";
	document.getElementById('tableConfiguration-9-4').innerHTML = "Hard";
	document.getElementById('tableConfiguration-10-1').innerHTML = "Defense on authors preferred timeslot tag";
	document.getElementById('tableConfiguration-10-2').childNodes[0].value = "15";
	document.getElementById('tableConfiguration-10-3').innerHTML = "Kaitsmine toimub lõputöö kaitsja eelistatud aja märksõnal";
	document.getElementById('tableConfiguration-10-4').innerHTML = "Soft";
	document.getElementById('tableConfiguration-11-1').innerHTML = "Defense not on authors not preferred timeslot tag";
	document.getElementById('tableConfiguration-11-2').childNodes[0].value = "10";
	document.getElementById('tableConfiguration-11-3').innerHTML = "Kaitsmine ei toimu lõputöö kaitsja mitte-eelistatud aja märksõnal";
	document.getElementById('tableConfiguration-11-4').innerHTML = "Soft";
	document.getElementById('tableConfiguration-12-1').innerHTML = "Defense not on authors supervisors unavailable timeslot";
	document.getElementById('tableConfiguration-12-2').childNodes[0].value = "20";
	document.getElementById('tableConfiguration-12-3').innerHTML = "Kaitsmine ei toimu lõputöö kaitsja juhendaja sobimatul kuupäeva kellaajal";
	document.getElementById('tableConfiguration-12-4').innerHTML = "Soft";
	document.getElementById('tableConfiguration-13-1').innerHTML = "Defense on authors supervisors preferred timeslot";
	document.getElementById('tableConfiguration-13-2').childNodes[0].value = "10";
	document.getElementById('tableConfiguration-13-3').innerHTML = "Kaitsmine toimub lõputöö kaitsja juhendaja eelistatud kuupäeva kellaajal";
	document.getElementById('tableConfiguration-13-4').innerHTML = "Soft";
	document.getElementById('tableConfiguration-14-1').innerHTML = "Defense not on authors supervisors not preferred timeslot";
	document.getElementById('tableConfiguration-14-2').childNodes[0].value = "15";
	document.getElementById('tableConfiguration-14-3').innerHTML = "Kaitsmine ei toimu lõputöö kaitsja juhendaja mitte-eelistatud kuupäeva kellaajal";
	document.getElementById('tableConfiguration-14-4').innerHTML = "Soft";
	document.getElementById('tableConfiguration-15-1').innerHTML = "Defense not on authors supervisors unavailable timeslot tag";
	document.getElementById('tableConfiguration-15-2').childNodes[0].value = "20";
	document.getElementById('tableConfiguration-15-3').innerHTML = "Kaitsmine ei toimu lõputöö kaitsja juhendaja sobimatul aja märksõnal";
	document.getElementById('tableConfiguration-15-4').innerHTML = "Soft";
	document.getElementById('tableConfiguration-16-1').innerHTML = "Defense on authors supervisors preferred timeslot tag";
	document.getElementById('tableConfiguration-16-2').childNodes[0].value = "10";
	document.getElementById('tableConfiguration-16-3').innerHTML = "Kaitsmine toimub lõputöö kaitsja juhendaja eelistatud aja märksõnal";
	document.getElementById('tableConfiguration-16-4').innerHTML = "Soft";
	document.getElementById('tableConfiguration-17-1').innerHTML = "Defense not on authors supervisors not preferred timeslot tag";
	document.getElementById('tableConfiguration-17-2').childNodes[0].value = "15";
	document.getElementById('tableConfiguration-17-3').innerHTML = "Kaitsmine ei toimu lõputöö kaitsja juhendaja mitte-eelistatud aja märksõnal";
	document.getElementById('tableConfiguration-17-4').innerHTML = "Soft";
	document.getElementById('tableConfiguration-18-1').innerHTML = "Defense not on commission members unavailable timeslot";
	document.getElementById('tableConfiguration-18-2').childNodes[0].value = "10";
	document.getElementById('tableConfiguration-18-3').innerHTML = "Kaitsmine ei toimu komisjoni liikme sobimatul kuupäeva kellaajal";
	document.getElementById('tableConfiguration-18-4').innerHTML = "Hard";
	document.getElementById('tableConfiguration-19-1').innerHTML = "Defense on commission members preferred timeslot";
	document.getElementById('tableConfiguration-19-2').childNodes[0].value = "15";
	document.getElementById('tableConfiguration-19-3').innerHTML = "Kaitsmine toimub komisjoni liikme eelistatud kuupäeva kellaajal";
	document.getElementById('tableConfiguration-19-4').innerHTML = "Soft";
	document.getElementById('tableConfiguration-20-1').innerHTML = "Defense not on commission members not preferred timeslot";
	document.getElementById('tableConfiguration-20-2').childNodes[0].value = "20";
	document.getElementById('tableConfiguration-20-3').innerHTML = "Kaitsmine ei toimu komisjoni liikme mitte-eelistatud kuupäeva kellaajal";
	document.getElementById('tableConfiguration-20-4').innerHTML = "Soft";
	document.getElementById('tableConfiguration-21-1').innerHTML = "Defense not on commission members unavailable timeslot tag";
	document.getElementById('tableConfiguration-21-2').childNodes[0].value = "20";
	document.getElementById('tableConfiguration-21-3').innerHTML = "Kaitsmine ei toimu komisjoni liikme sobimatul aja märksõnal";
	document.getElementById('tableConfiguration-21-4').innerHTML = "Hard";
	document.getElementById('tableConfiguration-22-1').innerHTML = "Defense on commission members preferred timeslot tag";
	document.getElementById('tableConfiguration-22-2').childNodes[0].value = "10";
	document.getElementById('tableConfiguration-22-3').innerHTML = "Kaitsmine toimub komisjoni liikme eelistatud aja märksõnal";
	document.getElementById('tableConfiguration-22-4').innerHTML = "Soft";
	document.getElementById('tableConfiguration-23-1').innerHTML = "Defense not on commission members not preferred timeslot tag";
	document.getElementById('tableConfiguration-23-2').childNodes[0].value = "15";
	document.getElementById('tableConfiguration-23-3').innerHTML = "Kaitsmine ei toimu komisjoni liikme mitte-eelistatud aja märksõnal";
	document.getElementById('tableConfiguration-23-4').innerHTML = "Soft";
}

let generatedKeyWords = ["võtmesõna-1", "võtmesõna-2", "võtmesõna-3", "võtmesõna-4", "võtmesõna-5", "võtmesõna-6", "võtmesõna-7"];
let generatedSupervisorsArray = [];
let generatedAuthorsArray = [];
let generatedCommiteeArray = [];
let generatedDefenseArray = [];
let generatedTimeslotKeys = ["Ei sobi", "Ei eelista", "Eelistab"];


// closedTimeslotType valikud: iga päev algus ja lõpp, iga päev algus, iga päev lõpp, viimasel päeval.
function generateTimeslotTable(days, timeslotsPerDay, sessions, startTime, startDate, closedTimeslotType, closedTimeslots, timeLength, breakLength, randomize){
	// Add first timeslot row headers
	document.getElementById('tableTimeslot-1-1').innerHTML = "Päev";
	document.getElementById('tableTimeslot-1-2').innerHTML = "Algus";
	document.getElementById('tableTimeslot-1-3').innerHTML = "Lõpp";
	document.getElementById('tableTimeslot-1-4').innerHTML = "Kaitsmise tüüp";
	document.getElementById('tableTimeslot-1-5').innerHTML = "Sessioon";
	document.getElementById('tableTimeslot-1-6').innerHTML = "Võtmesõnad";

	// startDate variables
	let dayInt = parseInt(startDate.substr(0, 2));
	let monthInt = parseInt(startDate.substr(3, 2));
	let yearInt = parseInt(startDate.substr(6, 4));

	// startTime variables
	let hourInt = parseInt(startTime.substr(0, 2));
	let minInt = parseInt(startTime.substr(3, 2));
	let currentHour = hourInt;
	let currentMin = minInt;

	// length variables
	let timeLengthInt = parseInt(timeLength);
	let breakLengthInt = parseInt(breakLength);

	// timeslot variables
	let daysInt = parseInt(days);
	let timeslotsPerDayInt = parseInt(timeslotsPerDay);
	let timeslotsTotal = timeslotsPerDayInt * daysInt;
	let sessionsInt = parseInt(sessions);
	let breakNumPerDay = sessionsInt - 1;
	let breaksTotal = breakNumPerDay * daysInt;
	let totalTimeslots = timeslotsTotal + breaksTotal;
	let daysSet = 1;

	// closed timeslot variables
	let closedTimelotsInt = parseInt(closedTimeslots);
	let closedTimeslotsLeft = closedTimelotsInt;
	let closedTimeslotsPerDay = Math.ceil(closedTimelotsInt / sessionsInt);

	let timeslotsPerSession = Math.ceil(timeslotsPerDayInt / sessionsInt);

	let timeslotNumber = 2;
	let numOfTimeslotForDay = 0;

	let sessionNumber = 1;

	for(let i = 0; i < daysInt; i++){

		for(let j = 0; j < timeslotsPerDay; j++){
			// add break timeslot first if at right time
			if(j % timeslotsPerSession == 0 && j != 0){
				addRow();
				document.querySelector('#tableTimeslot-' + timeslotNumber + '-1').innerHTML = getDoubleDigit(dayInt) + "." + getDoubleDigit(monthInt) + "." + yearInt.toString();
				document.querySelector('#tableTimeslot-' + timeslotNumber + '-2').innerHTML = getDoubleDigit(currentHour) + ":" + getDoubleDigit(currentMin);
				currentMin += breakLengthInt;
				if(currentMin > 59){
					currentHour++;
					currentMin = currentMin - 60;
				}
				document.querySelector('#tableTimeslot-' + timeslotNumber + '-3').innerHTML = getDoubleDigit(currentHour) + ":" + getDoubleDigit(currentMin);
				document.querySelector('#tableTimeslot-' + timeslotNumber + '-4').childNodes[0].value = "Vaheaeg";
				document.querySelector('#tableTimeslot-' + timeslotNumber + '-5').childNodes[0].value = 0;
				document.querySelector('#tableTimeslot-' + timeslotNumber + '-6').childNodes[0].value = "";
				timeslotNumber++;
				sessionNumber++;
			}

			// add new timeslot row
			addRow();
			document.querySelector('#tableTimeslot-' + timeslotNumber + '-1').innerHTML = getDoubleDigit(dayInt) + "." + getDoubleDigit(monthInt) + "." + yearInt.toString();
			document.querySelector('#tableTimeslot-' + timeslotNumber + '-2').innerHTML = getDoubleDigit(currentHour) + ":" + getDoubleDigit(currentMin);
			currentMin += timeLengthInt;
			if(currentMin > 59){
				currentHour++;
				currentMin = currentMin - 60;
			}
			document.querySelector('#tableTimeslot-' + timeslotNumber + '-3').innerHTML = getDoubleDigit(currentHour) + ":" + getDoubleDigit(currentMin);
			document.querySelector('#tableTimeslot-' + timeslotNumber + '-4').childNodes[0].value = "Lahtine";
			document.querySelector('#tableTimeslot-' + timeslotNumber + '-5').childNodes[0].value = sessionNumber;
			if(randomize == "yes"){
				let randomChance = Math.floor((Math.random() * 15) + 1);
				if(randomChance == 1){
					let randomKeyWord = Math.floor((Math.random() * generatedKeyWords.length));
					document.querySelector('#tableTimeslot-' + timeslotNumber + '-6').childNodes[0].value = generatedKeyWords[randomKeyWord];
				}
			}
			else {
				document.querySelector('#tableTimeslot-' + timeslotNumber + '-6').childNodes[0].value = "";
			}
			timeslotNumber++;

			// add closed timeslot, if choice is viimasel päeval
			if(daysSet == daysInt && closedTimeslotType == "viimasel päeval" && j == timeslotsPerDay-1){
				addRow();
				document.querySelector('#tableTimeslot-' + timeslotNumber + '-1').innerHTML = getDoubleDigit(dayInt) + "." + getDoubleDigit(monthInt) + "." + yearInt.toString();
				document.querySelector('#tableTimeslot-' + timeslotNumber + '-2').innerHTML = getDoubleDigit(currentHour) + ":" + getDoubleDigit(currentMin);
				currentMin += breakLengthInt;
				if(currentMin > 59){
					currentHour++;
					currentMin = currentMin - 60;
				}
				document.querySelector('#tableTimeslot-' + timeslotNumber + '-3').innerHTML = getDoubleDigit(currentHour) + ":" + getDoubleDigit(currentMin);
				document.querySelector('#tableTimeslot-' + timeslotNumber + '-4').childNodes[0].value = "Vaheaeg";
				document.querySelector('#tableTimeslot-' + timeslotNumber + '-5').childNodes[0].value = 0;
				document.querySelector('#tableTimeslot-' + timeslotNumber + '-6').childNodes[0].value = "";
				timeslotNumber++;
				sessionNumber++;
				let k;
				for(k = 0; k < closedTimelotsInt; k++){
					addRow();
					document.querySelector('#tableTimeslot-' + timeslotNumber + '-1').innerHTML = getDoubleDigit(dayInt) + "." + getDoubleDigit(monthInt) + "." + yearInt.toString();
					document.querySelector('#tableTimeslot-' + timeslotNumber + '-2').innerHTML = getDoubleDigit(currentHour) + ":" + getDoubleDigit(currentMin);
					currentMin += timeLengthInt;
					if(currentMin > 59){
						currentHour++;
						currentMin = currentMin - 60;
					}
					document.querySelector('#tableTimeslot-' + timeslotNumber + '-3').innerHTML = getDoubleDigit(currentHour) + ":" + getDoubleDigit(currentMin);
					document.querySelector('#tableTimeslot-' + timeslotNumber + '-4').childNodes[0].value = "Kinnine";
					document.querySelector('#tableTimeslot-' + timeslotNumber + '-5').childNodes[0].value = sessionNumber;
					document.querySelector('#tableTimeslot-' + timeslotNumber + '-6').childNodes[0].value = "";
					timeslotNumber++;
				}
			}
		}
		currentHour = hourInt;
		currentMin = minInt;
		dayInt++;
		sessionNumber++;
		daysSet++;
	}
}

function getDoubleDigit(date){
	if(date < 10){
		return "0" + date;
	}
	return date.toString();
}

function generateSupervisorTable(amount){
	// add first and second row first
	document.getElementById('tableSupervisor-1-1').innerHTML = "";
	document.getElementById('tableSupervisor-1-2').innerHTML = "";
	document.getElementById('tableSupervisor-1-3').innerHTML = "";
	document.getElementById('tableSupervisor-1-4').innerHTML = "";
	document.getElementById('tableSupervisor-1-5').innerHTML = "";
	document.getElementById('tableSupervisor-2-1').innerHTML = "Nimi";
	document.getElementById('tableSupervisor-2-2').innerHTML = "Roll";
	document.getElementById('tableSupervisor-2-3').innerHTML = "Eelistatud märksõnad";
	document.getElementById('tableSupervisor-2-4').innerHTML = "Mitte-eelistatud märksõnad";
	document.getElementById('tableSupervisor-2-5').innerHTML = "Sobimatud märksõnad";
	let columns = document.querySelector('#tableSupervisor').childNodes[0].childNodes[0].childElementCount;

	let oldTimeslotDate = "";
	let oldKey = "";
	let i;
	for(i = 0; i < amount; i++){
		addRow();
		document.querySelector('#tableSupervisor-' + (i+3) + '-1').innerHTML = "Juhendaja-" + (i+1);
		let randomKeyWord = Math.floor((Math.random() * generatedKeyWords.length));
		let randomChance = Math.floor((Math.random() * 10) + 1);
		if(randomChance == 1){
			document.querySelector('#tableSupervisor-' + (i+3) + '-3').childNodes[0].value = generatedKeyWords[randomKeyWord];
		}
		randomKeyWord = Math.floor((Math.random() * generatedKeyWords.length));
		randomChance = Math.floor((Math.random() * 10) + 1);
		if(randomChance == 1){
			document.querySelector('#tableSupervisor-' + (i+3) + '-4').childNodes[0].value = generatedKeyWords[randomKeyWord];
		}
		randomKeyWord = Math.floor((Math.random() * generatedKeyWords.length));
		randomChance = Math.floor((Math.random() * 10) + 1);
		if(randomChance == 1){
			document.querySelector('#tableSupervisor-' + (i+3) + '-5').childNodes[0].value = generatedKeyWords[randomKeyWord];
		}
		let j;
		for(j = 5; j < columns; j++){
			let timeslotDate = document.querySelector('#tableSupervisor').childNodes[0].childNodes[0].childNodes[j].innerHTML;
			if(oldTimeslotDate != timeslotDate){
				oldKey = "";
				randomKey = Math.floor((Math.random() * generatedTimeslotKeys.length));
				randomChance = Math.floor((Math.random() * 10) + 1);
				if(randomChance == 1){
					oldKey = generatedTimeslotKeys[randomKey];
					document.querySelector('#tableSupervisor').childNodes[0].childNodes[i+2].childNodes[j].childNodes[0].value = oldKey;
				}	
				
			}
			else if(oldTimeslotDate == timeslotDate) {
				document.querySelector('#tableSupervisor').childNodes[0].childNodes[i+2].childNodes[j].childNodes[0].value = oldKey;
			}
			oldTimeslotDate = timeslotDate;
		}
		generatedSupervisorsArray[i] = "Juhendaja-" + (i+1);
	}
}

function generateAuthorTable(amount){
	// add first and second row first
	document.getElementById('tableAuthor-1-1').innerHTML = "";
	document.getElementById('tableAuthor-1-2').innerHTML = "";
	document.getElementById('tableAuthor-1-3').innerHTML = "";
	document.getElementById('tableAuthor-1-4').innerHTML = "";
	document.getElementById('tableAuthor-1-5').innerHTML = "";
	document.getElementById('tableAuthor-1-6').innerHTML = "";
	document.getElementById('tableAuthor-2-1').innerHTML = "Nimi";
	document.getElementById('tableAuthor-2-2').innerHTML = "Eeldused on täidetud";
	document.getElementById('tableAuthor-2-3').innerHTML = "Juhendajad";
	document.getElementById('tableAuthor-2-4').innerHTML = "Eelistatud märksõnad";
	document.getElementById('tableAuthor-2-5').innerHTML = "Mitte-eelistatud märksõnad";
	document.getElementById('tableAuthor-2-6').innerHTML = "Sobimatud märksõnad";
	let columns = document.querySelector('#tableAuthor').childNodes[0].childNodes[0].childElementCount;

	let oldTimeslotDate = "";
	let oldKey = "";
	let i;
	for(i = 0; i < amount; i++){
		addRow();
		document.querySelector('#tableAuthor-' + (i+3) + '-1').innerHTML = "Autor-" + (i+1);

		let randomSupervisor = Math.floor((Math.random() * generatedSupervisorsArray.length));
		let randomSupervisor2;
		document.querySelector('#tableAuthor').childNodes[0].childNodes[i+2].childNodes[2].childNodes[0].value = generatedSupervisorsArray[randomSupervisor];
		let randomChanceSupervisor = Math.floor((Math.random() * 10) + 1);
		if(randomChanceSupervisor == 1) {
			document.querySelector('#tableAuthor').childNodes[0].childNodes[i+2].childNodes[2].childNodes[1].click();
			while(true){
				randomSupervisor2 = Math.floor((Math.random() * generatedSupervisorsArray.length));
				if(randomSupervisor != randomSupervisor2){
					document.querySelector('#tableAuthor').childNodes[0].childNodes[i+2].childNodes[2].childNodes[1].value = generatedSupervisorsArray[randomSupervisor2];
					break;
				}
			}
		}

		let randomKeyWord = Math.floor((Math.random() * generatedKeyWords.length));
		let randomChance = Math.floor((Math.random() * 10) + 1);
		if(randomChance == 1){
			document.querySelector('#tableAuthor-' + (i+3) + '-4').childNodes[0].value = generatedKeyWords[randomKeyWord];
		}
		randomKeyWord = Math.floor((Math.random() * generatedKeyWords.length));
		randomChance = Math.floor((Math.random() * 10) + 1);
		if(randomChance == 1){
			document.querySelector('#tableAuthor-' + (i+3) + '-5').childNodes[0].value = generatedKeyWords[randomKeyWord];
		}
		randomKeyWord = Math.floor((Math.random() * generatedKeyWords.length));
		randomChance = Math.floor((Math.random() * 10) + 1);
		if(randomChance == 1){
			document.querySelector('#tableAuthor-' + (i+3) + '-6').childNodes[0].value = generatedKeyWords[randomKeyWord];
		}
		let j;
		for(j = 6; j < columns; j++){
			let timeslotDate = document.querySelector('#tableAuthor').childNodes[0].childNodes[0].childNodes[j].innerHTML;
			if(oldTimeslotDate != timeslotDate){
				oldKey = "";
				randomKey = Math.floor((Math.random() * generatedTimeslotKeys.length));
				randomChance = Math.floor((Math.random() * 5) + 1);
				if(randomChance == 1){
					oldKey = generatedTimeslotKeys[randomKey];
					document.querySelector('#tableAuthor').childNodes[0].childNodes[i+2].childNodes[j].childNodes[0].value = oldKey;
				}	
			}
			else if(oldTimeslotDate == timeslotDate) {
				document.querySelector('#tableAuthor').childNodes[0].childNodes[i+2].childNodes[j].childNodes[0].value = oldKey;
			}
			oldTimeslotDate = timeslotDate;
		}
		generatedAuthorsArray[i] = "Autor-" + (i+1);
	}
}

function generateCommiteeTable(amount){
	// add first and second row first
	document.getElementById('tableCommitee-1-1').innerHTML = "";
	document.getElementById('tableCommitee-1-2').innerHTML = "";
	document.getElementById('tableCommitee-1-3').innerHTML = "";
	document.getElementById('tableCommitee-1-4').innerHTML = "";
	document.getElementById('tableCommitee-1-5').innerHTML = "";
	document.getElementById('tableCommitee-1-6').innerHTML = "";
	document.getElementById('tableCommitee-2-1').innerHTML = "Nimi";
	document.getElementById('tableCommitee-2-2').innerHTML = "Kraad";
	document.getElementById('tableCommitee-2-3').innerHTML = "Esimees";
	document.getElementById('tableCommitee-2-4').innerHTML = "Eelistatud märksõnad";
	document.getElementById('tableCommitee-2-5').innerHTML = "Mitte-eelistatud märksõnad";
	document.getElementById('tableCommitee-2-6').innerHTML = "Sobimatud märksõnad";
	let columns = document.querySelector('#tableCommitee').childNodes[0].childNodes[0].childElementCount;

	let oldTimeslotDate = "";
	let oldKey = "";
	let i;
	for(i = 0; i < amount; i++){
		addRow();
		document.querySelector('#tableCommitee-' + (i+3) + '-1').innerHTML = "Komisjon-" + (i+1);

		if(i == 0){
			document.querySelector('#tableCommitee-' + (i+3) + '-3').childNodes[0].value = "Esimees";
		}
		else if(i == 1){
			document.querySelector('#tableCommitee-' + (i+3) + '-3').childNodes[0].value = "Aseesimees";
		}

		let randomKeyWord = Math.floor((Math.random() * generatedKeyWords.length));
		let randomChance = Math.floor((Math.random() * 10) + 1);
		if(randomChance == 1){
			document.querySelector('#tableCommitee-' + (i+3) + '-4').childNodes[0].value = generatedKeyWords[randomKeyWord];
		}
		randomKeyWord = Math.floor((Math.random() * generatedKeyWords.length));
		randomChance = Math.floor((Math.random() * 10) + 1);
		if(randomChance == 1){
			document.querySelector('#tableCommitee-' + (i+3) + '-5').childNodes[0].value = generatedKeyWords[randomKeyWord];
		}
		randomKeyWord = Math.floor((Math.random() * generatedKeyWords.length));
		randomChance = Math.floor((Math.random() * 10) + 1);
		if(randomChance == 1){
			document.querySelector('#tableCommitee-' + (i+3) + '-6').childNodes[0].value = generatedKeyWords[randomKeyWord];
		}
		let j;
		for(j = 6; j < columns; j++){
			let timeslotDate = document.querySelector('#tableCommitee').childNodes[0].childNodes[0].childNodes[j].innerHTML;
			if(oldTimeslotDate != timeslotDate){
				oldKey = "";
				randomKey = Math.floor((Math.random() * generatedTimeslotKeys.length));
				randomChance = Math.floor((Math.random() * 10) + 1);
				if(randomChance == 1){
					oldKey = generatedTimeslotKeys[randomKey];
					document.querySelector('#tableCommitee').childNodes[0].childNodes[i+2].childNodes[j].childNodes[0].value = oldKey;
				}	
				
			}
			else if(oldTimeslotDate == timeslotDate) {
				document.querySelector('#tableCommitee').childNodes[0].childNodes[i+2].childNodes[j].childNodes[0].value = oldKey;
			}
			oldTimeslotDate = timeslotDate;
		}
		generatedCommiteeArray[i] = "Komisjon-" + (i+1);
	}
}

function generateDefenseTable(amount){
	// add first and second row first
	document.getElementById('tableDefense-1-1').innerHTML = "Lõputöö pealkiri";
	document.getElementById('tableDefense-1-2').innerHTML = "Kood";
	document.getElementById('tableDefense-1-3').innerHTML = "Kaitsmise tüüp";
	document.getElementById('tableDefense-1-4').innerHTML = "Lõputöö kraad";
	document.getElementById('tableDefense-1-5').innerHTML = "Lõputöö autor";
	document.getElementById('tableDefense-1-6').innerHTML = "Sarnane lõputöö teema";
	document.getElementById('tableDefense-1-7').innerHTML = "Ruumi nr";
	document.getElementById('tableDefense-1-8').innerHTML = "Ruumi maht";
	document.getElementById('tableDefense-1-9').innerHTML = "Komisjoni suurus";

	let i;
	for(i = 0; i < amount; i++){
		addRow();
		if(i < 9) {
			document.querySelector('#tableDefense-' + (i+2) + '-2').innerHTML = "D00" + (i+1);
		} else if(i < 99){
			document.querySelector('#tableDefense-' + (i+2) + '-2').innerHTML = "D0" + (i+1);
		} else{
			document.querySelector('#tableDefense-' + (i+2) + '-2').innerHTML = "D" + (i+1);
		}
		document.querySelector('#tableDefense-' + (i+2) + '-1').innerHTML = "Kaitsmine-" + (i+1);

		let randomChance = Math.floor((Math.random() * 100) + 1);
		if(randomChance == 1){
			document.querySelector('#tableDefense-' + (i+2) + '-3').childNodes[0].value = "Kinnine";
		} else {
			document.querySelector('#tableDefense-' + (i+2) + '-3').childNodes[0].value = "Lahtine";
		}
		while(true){
			randomKeyWord = Math.floor((Math.random() * generatedAuthorsArray.length));
			if(generatedAuthorsArray[randomKeyWord] != ""){
				document.querySelector('#tableDefense-' + (i+2) + '-5').childNodes[0].value = generatedAuthorsArray[randomKeyWord];
				generatedAuthorsArray[randomKeyWord] = "";
				break;
			}
		}
		document.querySelector('#tableDefense-' + (i+2) + '-7').innerHTML = "ICT-410";
		document.querySelector('#tableDefense-' + (i+2) + '-9').childNodes[0].value = "3";
	}
}

function generateTimeslotTableTemplate(){
	document.getElementById('tableTimeslot-1-1').innerHTML = "Päev";
	document.getElementById('tableTimeslot-1-2').innerHTML = "Algus";
	document.getElementById('tableTimeslot-1-3').innerHTML = "Lõpp";
	document.getElementById('tableTimeslot-1-4').innerHTML = "Kaitsmise tüüp";
	document.getElementById('tableTimeslot-1-5').innerHTML = "Sessioon";
	document.getElementById('tableTimeslot-1-6').innerHTML = "Võtmesõnad";
}

function generateAuthorTableTemplate(){
	document.getElementById('tableAuthor-1-1').innerHTML = "";
	document.getElementById('tableAuthor-1-2').innerHTML = "";
	document.getElementById('tableAuthor-1-3').innerHTML = "";
	document.getElementById('tableAuthor-1-4').innerHTML = "";
	document.getElementById('tableAuthor-1-5').innerHTML = "";
	document.getElementById('tableAuthor-1-6').innerHTML = "";
	document.getElementById('tableAuthor-2-1').innerHTML = "Nimi";
	document.getElementById('tableAuthor-2-2').innerHTML = "Eeldused on täidetud";
	document.getElementById('tableAuthor-2-3').innerHTML = "Juhendajad";
	document.getElementById('tableAuthor-2-4').innerHTML = "Eelistatud märksõnad";
	document.getElementById('tableAuthor-2-5').innerHTML = "Mitte-eelistatud märksõnad";
	document.getElementById('tableAuthor-2-6').innerHTML = "Sobumatud märksõnad";
}

function generateSupervisorTableTemplate(){
	document.getElementById('tableSupervisor-1-1').innerHTML = "";
	document.getElementById('tableSupervisor-1-2').innerHTML = "";
	document.getElementById('tableSupervisor-1-3').innerHTML = "";
	document.getElementById('tableSupervisor-1-4').innerHTML = "";
	document.getElementById('tableSupervisor-1-5').innerHTML = "";
	document.getElementById('tableSupervisor-2-1').innerHTML = "Nimi";
	document.getElementById('tableSupervisor-2-2').innerHTML = "Roll";
	document.getElementById('tableSupervisor-2-3').innerHTML = "Eelistatud märksõnad";
	document.getElementById('tableSupervisor-2-4').innerHTML = "Mitte-eelistatud märksõnad";
	document.getElementById('tableSupervisor-2-5').innerHTML = "Sobumatud märksõnad";
}

function generateCommiteeTableTemplate(){
	document.getElementById('tableCommitee-1-1').innerHTML = "";
	document.getElementById('tableCommitee-1-2').innerHTML = "";
	document.getElementById('tableCommitee-1-3').innerHTML = "";
	document.getElementById('tableCommitee-1-4').innerHTML = "";
	document.getElementById('tableCommitee-1-5').innerHTML = "";
	document.getElementById('tableCommitee-1-6').innerHTML = "";
	document.getElementById('tableCommitee-2-1').innerHTML = "Nimi";
	document.getElementById('tableCommitee-2-2').innerHTML = "Kraad";
	document.getElementById('tableCommitee-2-3').innerHTML = "Esimees";
	document.getElementById('tableCommitee-2-4').innerHTML = "Eelistatud märksõnad";
	document.getElementById('tableCommitee-2-5').innerHTML = "Mitte-eelistatud märksõnad";
	document.getElementById('tableCommitee-2-6').innerHTML = "Sobumatud märksõnad";
}

function generateDefenseTableTemplate(){
	document.getElementById('tableDefense-1-1').innerHTML = "Lõputöö pealkiri";
	document.getElementById('tableDefense-1-2').innerHTML = "Kood";
	document.getElementById('tableDefense-1-3').innerHTML = "Kaitsmise tüüp";
	document.getElementById('tableDefense-1-4').innerHTML = "Lõputöö kraad";
	document.getElementById('tableDefense-1-5').innerHTML = "Lõputöö autor";
	document.getElementById('tableDefense-1-6').innerHTML = "Sarnane lõputöö teema";
	document.getElementById('tableDefense-1-7').innerHTML = "Ruumi nr";
	document.getElementById('tableDefense-1-8').innerHTML = "Ruumi maht";
	document.getElementById('tableDefense-1-9').innerHTML = "Komisjoni suurus";
}

