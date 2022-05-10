import React, { useState } from "react";
import ReactDOM from "react-dom";

import "./styles.css";
import {Button} from "react-bootstrap";
import App from "../App";
import LoggedIn from "../LoggedIn";

function Login() {
    // React States
    const [errorMessages, setErrorMessages] = useState({});
    const [isSubmitted, setIsSubmitted] = useState(false);

    function myFunction() {
        const x = document.getElementById("myDIV");
        if (x.style.display === "none") {
            x.style.display = "block";
        } else {
            x.style.display = "none";
        }
    }

    // User Login info
    const database = [
        {
            username: "Jozo",
            password: "pass1"
        },
    ];

    const errors = {
        uname: "invalid username",
        pass: "invalid password"
    };

    const handleSubmit = (event) => {
        //Prevent page reload
        event.preventDefault();

        var { uname, pass } = document.forms[0];

        // Find user login info
        const userData = database.find((user) => user.username === uname.value);

        // Compare user info
        if (userData) {
            if (userData.password !== pass.value) {
                // Invalid password
                setErrorMessages({ name: "pass", message: errors.pass });
            } else {
                setIsSubmitted(true);
            }
        } else {
            // Username not found
            setErrorMessages({ name: "uname", message: errors.uname });
        }
    };

    // Generate JSX code for error message
    const renderErrorMessage = (name) =>
        name === errorMessages.name && (
            <div className="error">{errorMessages.message}</div>
        );

    // JSX code for login form
    const renderForm = (
        <div className="form">
            <form onSubmit={handleSubmit}>
                <div className="input-container">
                    <label>Username </label>
                    <input type="text" name="uname" required />
                    {renderErrorMessage("uname")}
                </div>
                <div className="input-container">
                    <label>Password </label>
                    <input type="password" name="pass" required />
                    {renderErrorMessage("pass")}
                </div>
                <div className="button-container">
                    <input type="submit"/>
                </div>
            </form>
        </div>
    );

    return (
        <div className="app" id="myDIV">
            <div className="button-container">
            </div>
            <div className="login-form">
                <div className="title">Sign In</div>
                {isSubmitted ? <div>Successfully signed in</div> : renderForm}
                <Button className="special" onClick={myFunction}>Hide</Button>
            </div>
        </div>
    );
}

const rootElement = document.getElementById("root");
ReactDOM.render(<Login/>, rootElement);

export default Login;