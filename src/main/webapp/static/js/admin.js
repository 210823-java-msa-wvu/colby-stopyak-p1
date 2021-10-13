
function updateManager() {
    console.log("clicking add")

    // console.log(document.getElementById('status').value);
    // console.log(document.getElementById('rm_id').value);
    // console.log(document.getElementById('emp_id').value);
    let rm_idInput = document.getElementById('rm_id').value;
    console.log(rm_idInput);
    let data = {
        rm_id: rm_idInput,
        amount: document.getElementById('amount').value,
        // work_related: document.getElementById('work_related').value,
        status: document.getElementById('status').value,

        is_approved: false

    }
    console.log(status);
    // console.log("desciption" + descriptionI)
    console.log(JSON.stringify(data));
    // console.log(newForm);


    let xhttp = new XMLHttpRequest();

    let url = `http://localhost:8080/colby-stopyak-p1h/reimbursement/`;
    // xhttp.open('PUT', url + rm_idInput, true)

    xhttp.open('PUT', url + rm_idInput, true);
    xhttp.setRequestHeader('Content-Type', 'application/json');

    xhttp.onreadystatechange = function () {
        if (this.readyState === 4 && this.status === 200) {
        }
    };
    // xhttp.send(data);
    xhttp.send(JSON.stringify(data));
}




function viewData() {
    let section = document.getElementById("tables")
    section.innerHTML = '<div> </div>';

    let xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = recieveData;
    xhttp.open('GET', 'http://localhost:8080/colby-stopyak-p1h/reimbursement/');
    xhttp.send();


    function recieveData() {
        if (xhttp.readyState == 4 && xhttp.status == 200) {
            let r = xhttp.responseText;
            r = JSON.parse(r);
            populateData(r);

        }
    }
}

function populateData(response){


    let section = document.getElementById("tables");
    section.innerHTML= '';

    //building the table

    let table = document.createElement("Table");
    
    section.appendChild(table);

    let head = document.createElement("tr");

    head.innerHTML = "<th> rm_id</th> <th> description</th> <th> amount</th><th> location</th><th> work related</th><th> status</th>";
    table.appendChild(head);

    for(let i = 0; i < response.length; i++){
        let rm_id = response[i].rm_id;
        let description = response[i].description;
        let amount = response[i].description;
        let location = response[i].location;
        let work_related = response[i].work_related;
        let status = response[i].status;

        let input = document.createElement("tr");

        input.innerHTML += `<td> ${response[i].rm_id} </td>`;
        input.innerHTML += `<td> ${response[i].description} </td>`;
        input.innerHTML += `<td> ${response[i].amount} </td>`;
        input.innerHTML += `<td> ${response[i].location} </td>`;
        input.innerHTML += `<td> ${response[i].work_related} </td>`;
        input.innerHTML += `<td> ${response[i].status} </td>`;
        table.appendChild(input);
    }


}



// function get(){
//     let xhttp = new XMLHttpRequest();

//     xhttp.onreadystatechange = function() {
//         console.log("state ready" + this.readyState);


//         if(this.readyState == 4 && this.status == 200){

//             req = JSON.parse(this.responseText)
//             console.log(req);


//             const tableRow = document.getElementById("tableRow")
//             tableRow.innerHTML = "";
//             req.array.forEach(res => {
//                 idArray.push(res.id);

//                 const content = `
//                     <tr>
//                         <th scope="row> ${res.id}> </th>
//                         <td> ${res.user.username} </td>
//                         <td> ${res.rm_id} </td>
//                         <td> ${res.description} </td>
//                         <td> ${res.location} </td>
//                         <td> ${res.amount} </td>
//                         <td> ${res.work_related} </td>
//                         <td> ${res.status} </td>
//                         <td> ${res.is_approved} </td>
//                         <td> ${res.user.emp_id} </td>
//                     </tr>


//                 `
//                 tableRow.innerHTML += content;
//             })
//         }
//     }

//     let url = `http://localhost:8080/colby-stopyak-p1h/reimbursement`

//     //step3
//     xhttp.open("GET", url, true);

//     //step4
//     xhttp.send();

// }




// function getReimbursements(){
//     console.log('click')
//     let url = 'http://localhost:8080/colby-stopyak-p1h/reimbursement';
//     let xhttp = new XMLHttpRequest();
//     xhttp.onreadystatechange = receiveData;

//     function receiveData(){
//         if(this.readyState == 4){
//             let response = this.responseText;
//             console.log(response);

//             response = JSON.parse(response);
//             table(response);

//         }
//     }
//     xhttp.open('GET', url, true)
//     xhttp.send();
// }

function getTable() {
    let arr = [];
    let xhttp = new XMLHttpRequest();

    if (this.onreadystatechange == 4 && this.status == 200) {

        req = JSON.parse(this.responseText);

        let tRow = document.getElementById("tRow");
        tRow.innerHTML = "";

        req.array.forEach(res => {
            arr.push(res.id);

            let tableContent = `
        <tr>
            <th scope ="row"> ${res.rm_id}</th>
            <td> ${res.description} </td>


        </tr>
        
        
        
        
        `
            tRow.innerHTML += tableContent;

        });
    }
    let url = `http://localhost:8080/colby-stopyak-p1h/reimbursement`;
    xhttp.open('GET', url, true);
    xhttp.send();
}

// function populateData(res) {

//     // This is where we will do our DOM manipulation
//     let dataSection = document.getElementById('data');

//     // Create a new element
//     let nameTag = document.createElement('h3');

//     // Add text to the inner html of the new element
//     // <h3>innerHtml</h3>
//     nameTag.innerHTML = res.rm_id;

//     // Append this new element to the section element (adding it as a child node in the DOM)
//     dataSection.appendChild(nameTag);


//     // Now we'll use the same process for the Abilities
//     let abilitiesArray = res.abilities;
//     console.log(abilitiesArray);

//     /**
//      * <ul>
//      *    <li>"Ability Name"</li>
//      *    <li>"Ability Name"</li>
//      *    <li>"Ability Name"</li>
//      * </ul>
//      */

//     // Create an unordered list element
//     let abilities = document.createElement('ul');
//     dataSection.innerHTML += 'Abilities<br>';
//     dataSection.appendChild(abilities);

//     // Iterate over the abilities array and create 'li' elements
//     for (let ability of abilitiesArray) { // for-of -> iterate over the elements inside the array
//         let abli = document.createElement('li');
//         abli.innerHTML = (ability.ability.name);
//         abilities.appendChild(abli);
//     }

// }

