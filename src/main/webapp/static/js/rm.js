// logic for reimbursement form

// document.getElementById('add').addEventListener("click", add);
async function getUser() {
    let url = 'http://localhost:8080/colby-stopyak-p1h/users';

    let res = await fetch(url)
    let data = await res.json()

        .then(data => {
            console.log(data);
            // getting the data
            localStorage.setItem("emp_id", JSON.stringify(data.emp_id));
            localStorage.setItem("title", JSON.stringify(data.title));
        })
        .catch(err => console.log(err));

}
function add() {
    console.log("clicking add")

    // let descriptionI = document.getElementById('description').value;
    // // let descriptionI = "we made it";
    // let locationI = document.getElementById('location').value;
    // let amountI = document.getElementById('amount').value;
    // let work_relatedI = document.getElementById('work_related').value;
    // let created_at = document.getElementById("created_at").value;

    let work_relatedI = document.getElementById('work_related').value;

    // let newForm = {
    //     user: {emp_id: localStorage.getItem('emp_id')},
    //     description: document.getElementById('description').value,
    //     location: document.getElementById('location').value,
    //     amount: document.getElementById('amount').value,
    //     work_related: document.getElementById('work_related').value,
    //     status: "pending",
    //     is_approved: false

    // }
    if(work_relatedI == "universityCourses")
        amount = amount * 0.8;
    
        
    else if (work_relatedI == "Seminars")
        amount = amount * 0.6;
    
        
    else if (work_relatedI == "certificationclass")
        amount = amount * 0.75;
    
        
    else if (work_relatedI == "certification")
        amount = amount;
    
        
    else if (work_relatedI == "technicalTraining")
        amount = amount * 0.9;
    
        
    else if(work_relatedI == "other")
        amount = amount * 0.3;
    
        
    if (amount > 1000)
            amount = 1000;
    

    let newForm = {
        user: {emp_id: localStorage.getItem('emp_id')},
        description: document.getElementById('description').value,
        location: document.getElementById('location').value,
        amount: document.getElementById('amount').value,
        work_related: work_relatedI,
        status: "pending",
        is_approved: false

    }
    // console.log("desciption" + descriptionI)
    console.log(JSON.stringify(newForm));
    // console.log(newForm);
   

    let xhttp = new XMLHttpRequest();

    xhttp.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200) {
            let resp = this.responseText;
            console.log(resp);
        }
    }
    xhttp.open('POST', 'http://localhost:8080/colby-stopyak-p1h/reimbursement', true);
    xhttp.setRequestHeader('Content-Type', 'application/json');
    // xhttp.send(JSON.stringify(newForm));
    xhttp.send(JSON.stringify(newForm));
}




//get all by emp id
// async function getRmById(){
//     let emp_id = document.getElementById('emp_id');

//     let url = 
// }


// gets all by rm id
function getReim() {
    let url = 'http://localhost:8080/colby-stopyak-p1h/reimbursement/';


    let xhr = new XMLHttpRequest();
    xhr.onreadystatechange = getData;

    function getData() {
        console.log(this.readyState);

        if (this.readyState == 4 & this.status == 200) {
            let req = this.responseText;
            req = JSON.parse(req);
            console.log(req);
        }
    }
    xhr.open('GET', url, true);
    xhr.send();

}



// function getReim() {
//     let url = 'http://localhost:8080/colby-stopyak-p1h/reimbursement/getmy/';


//     let xhr = new XMLHttpRequest();
//     xhr.onreadystatechange = getData;

//     function getData() {
//         console.log(this.readyState);

//         if (this.readyState == 4 & this.status == 200) {
//             let req = this.responseText;
//             req = JSON.parse(req);
//             console.log(req);
//         }
//     }
//     xhr.open('GET', url, true);
//     xhr.send();

// }

// document.getElementById('data').addEventListener("click", add);

// let url = 'http://localhost:8080/colby-stopyak-p1/reimbursements';

// function newRm(){
//     console.log(click);

//     let description = document.getElementById("description").value;
// 	let workRelated = document.getElementById("workRelated").value;
// 	let amount = document.getElementById("cost").value;
// 	let startDate = document.getElementById("startDate").valueAsNumber;

//     let request = {

// 		reqBy: emp_Id,
// 		description: document.getElementById('description').value,
// 		amount: document.getElementById('amount').value,
// 		work_related: document.getElementById('work_related').value,
// 		status: document.getElementById('status').value,
// 		is_approved: document.getElementById('is_approved').value,
// 		created_at: document.getElementById('created_at').value
//         }

//         let xttp = new XMLHttpRequest();

//         xttp.onreadystatechange = receiveData;



//         xttp.open('Post', url, true);
//         xttp.send();

//         function receiveData(){

//             let dateSection = document.getElementById('data');
//             dateSection.innerHTML = '';

//             if(xttp.readyState == 4 && xttp.status == 200) {
//                 let r = xttp.responseText;
//                 r = JSON.parse(r);
//                 console.log(r);
//                 populateData(r);
//             }

//         }

// }

function userLogout(){
    // Clear local storage
    localStorage.removeItem("username");
    

}