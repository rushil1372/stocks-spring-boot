var firebaseConfig = {
    apiKey: "AIzaSyC48l1Dj-nZyttz4B6Hojj3k0IbwpkFkkc",
    authDomain: "testform-5c8ed.firebaseapp.com",
    projectId: "testform-5c8ed",
    storageBucket: "testform-5c8ed.appspot.com",
    messagingSenderId: "955102970607",
    appId: "1:955102970607:web:48b792d2d73f755fabd11a"
  };
  // Initialize Firebase
  firebase.initializeApp(firebaseConfig);
  
  const auth = firebase.auth();
  var provider = new firebase.auth.GoogleAuthProvider();
  
  function signUp(){
    var email = document.getElementById("email");
    var password = document.getElementById("password");
  
    const promise = auth.createUserWithEmailAndPassword(email.value,password.value);
    promise.catch(e => alert(e.message));
    alert("Signed Up");
  }
  
  function signIn(){
    var email = document.getElementById("email");
    var password = document.getElementById("password");
  
    const promise = auth.signInWithEmailAndPassword(email.value,password.value);
    promise.catch(e => alert(e.message));
    alert("Signed In As " + email);
  }
  
  function signOut(){
    auth.signOut();
    alert("Signed Out");
  }
  
  function googleSignin() {
    firebase.auth().signInWithPopup(provider).then(function(result) {
    // This gives you a Google Access Token. You can use it to access the Google API.
    var token = result.credential.accessToken;
    // The signed-in user info.
    var user = result.user;
    // ...
  }).catch(function(error) {
    // Handle Errors here.
    var errorCode = error.code;
    var errorMessage = error.message;
    // The email of the user's account used.
    var email = error.email;
    // The firebase.auth.AuthCredential type that was used.
    var credential = error.credential;
    // ...
  });
  }
  