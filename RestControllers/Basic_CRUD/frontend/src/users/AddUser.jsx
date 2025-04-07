import React, { useState } from "react";
import axios from "axios";

const AddUser = () => {
  const [name, setName] = useState("");
  const [username, setUsername] = useState("");
  const [email, setEmail] = useState("");

  const createUsers = async () => {
    console.log("Inside");
    const result = await axios.post("http://localhost:8080/user", {
      name: name,
      userName: username,
      email: email,
    });
    setName("");
    setUsername("");
    setEmail("");
  };

  const cancleCreateUsers = async () => {
    setName("");
    setUsername("");
    setEmail("");
  };

  return (
    <div className="w-full flex flex-wrap justify-center">
      <div className="w-full flex flex-wrap justify-center text-white text-3xl mt-2 font-bold">
        <h1>ADD YOUR DETAILS</h1>
      </div>
      <div className="shadow-2xl w-[30%] mt-4 py-4 border border-blue-500 rounded-xl bg-custom-bg1">
        <div className="w-full flex flex-wrap justify-center p-2">
          <input
            required
            value={name}
            onChange={(e) => {
              setName(e.target.value);
            }}
            className="w-[80%] focus:outline focus:outline-blue-500 bg-custom-bg2 p-2 rounded-xl text-white"
            placeholder="Enter Your Username"
          />
        </div>
        <div className="w-full flex flex-wrap justify-center p-2 text-white">
          <input
            required
            value={username}
            onChange={(e) => {
              setUsername(e.target.value);
            }}
            className="w-[80%] focus:outline focus:outline-blue-500 bg-custom-bg2 p-2 rounded-xl"
            placeholder="Enter Your Name"
          />
        </div>
        <div className="w-full flex flex-wrap justify-center p-2 text-white">
          <input
            required
            value={email}
            onChange={(e) => {
              setEmail(e.target.value);
            }}
            className="w-[80%] focus:outline focus:outline-blue-500 bg-custom-bg2 p-2 rounded-xl"
            placeholder="Enter Your Email"
          />
        </div>
        <div className="w-full flex flex-wrap justify-center p-2">
          <button
            onClick={() => {
              createUsers();
            }}
            className="px-2 py-1 mx-2 border border-black rounded-md bg-blue-600 text-white"
          >
            Submit
          </button>
          <button
            onClick={() => {
              cancleCreateUsers();
            }}
            className="px-2 py-1 mx-2 border border-black rounded-md bg-blue-600 text-white"
          >
            Cancle
          </button>
        </div>
      </div>
    </div>
  );
};

export default AddUser;
