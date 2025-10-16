// Show current date and time at top-right
function showDateTime() {
  const dt = document.getElementById("datetime");
  const now = new Date();
  dt.textContent = now.toLocaleString();

  // Update every second
  setInterval(() => {
    const current = new Date();
    dt.textContent = current.toLocaleString();
  }, 1000);

  // Start 3-minute timer
  setTimeout(() => {
    alert("3 mins past");
  }, 180000);
}

function validateForm() {
  let fname = document.getElementById("fname").value.trim();
  let lname = document.getElementById("lname").value.trim();
  let password = document.getElementById("password").value;
  let cpassword = document.getElementById("cpassword").value;
  let genderMale = document.getElementById("male").checked;
  let genderFemale = document.getElementById("female").checked;
  let mobile = document.getElementById("mobile").value.trim();
  let dob = document.getElementById("dob").value.trim();
  let email = document.getElementById("email").value.trim();

  const nameRegex = /^[A-Za-z]+$/;
  const mobileRegex = /^(\d{3}[-.\s]\d{3}[-.\s]\d{4})$/;
  const dobRegex = /^(\d{2})-(\d{2})-(\d{4})$/;
  const emailRegex = /^[^@.][\w.-]*@[\w.-]+\.[A-Za-z]{2,}$/;

  // First Name
  if (fname === "" || !nameRegex.test(fname)) {
    alert("First Name must be entered and contain only letters");
    return false;
  }

  // Last Name
  if (lname === "" || !nameRegex.test(lname)) {
    alert("Last Name must be entered and contain only letters");
    return false;
  }

  // Password
  if (password.length < 6 || password.length > 20) {
    alert("Password length should be between 6 and 20 characters");
    return false;
  }

  // Confirm Password
  if (cpassword !== password) {
    alert("Password and Confirm Password must be same");
    return false;
  }

  // Gender
  if (!genderMale && !genderFemale) {
    alert("Please select Gender");
    return false;
  }

  // Mobile
  if (!mobileRegex.test(mobile)) {
    alert(
      "Mobile number must be in valid format: XXX-XXX-XXXX or XXX.XXX.XXXX or XXX XXX XXXX"
    );
    return false;
  }

  // DOB
  if (!dobRegex.test(dob)) {
    alert("DOB must be in DD-MM-YYYY format");
    return false;
  } else {
    const parts = dob.split("-");
    const enteredDate = new Date(parts[2], parts[1] - 1, parts[0]);
    if (enteredDate >= new Date()) {
      alert("DOB must be before today");
      return false;
    }
  }

  // Email
  if (!emailRegex.test(email)) {
    alert("Invalid Email format");
    return false;
  }

  alert("Form submitted successfully!");
  return true;
}
