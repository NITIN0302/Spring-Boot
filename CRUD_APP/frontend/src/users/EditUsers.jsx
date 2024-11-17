import React, { useState, useEffect } from "react";
import axios from "axios";
import Modal from "../Modal";

const EditUsers = () => {
  const [isModalOpen, setIsModalOpen] = useState(false);
  const [users, setUsers] = useState([]);
  const [updateid, setUpdateId] = useState();
  const [name, setName] = useState("");
  const [username, setUsername] = useState("");
  const [email, setEmail] = useState("");

  const openModal = () => setIsModalOpen(true);
  const closeModal = () => setIsModalOpen(false);

  useEffect(() => {
    getUsers();
  }, []);

  const getUsers = async () => {
    const result = await axios.get("http://localhost:8080/users");
    setUsers(result.data);
  };

  const openModalRoot = async (id) => {
    const result = await axios.get(`http://localhost:8080/users/${id}`);
    const resultdata = await result.data;
    setUpdateId(id);
    setUsername(resultdata.userName);
    setName(resultdata.name);
    setEmail(resultdata.email);
    openModal();
  };

  const updateUser = async (id) => {
    console.log(updateid);
    const result = await axios.put(`http://localhost:8080/users/${id}`, {
      userName: username,
      name: name,
      email: email,
    });
    closeModal();
  };

  return (
    <div className="flex flex-wrap justify-center">
      <Modal isOpen={isModalOpen} onClose={closeModal}>
        <div className="shadow-2xl w-full py-4 border border-blue-500 rounded-xl bg-custom-bg1">
          <div className="w-full flex flex-wrap justify-center text-white text-3xl font-bold">
            <h1>Update User</h1>
          </div>
          <div className="w-full flex flex-wrap justify-center p-2">
            <input
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
                updateUser(updateid);
              }}
              className="px-2 py-1 mx-2 border border-black rounded-md bg-blue-600 text-white"
            >
              Submit
            </button>
            <button
              onClick={() => {
                closeModal();
              }}
              className="px-2 py-1 mx-2 border border-black rounded-md bg-blue-600 text-white"
            >
              Cancle
            </button>
          </div>
        </div>
      </Modal>

      <div className="w-[70%] flex flex-wrap justify-around p-2  mt-4 bg-custom-bg1 border-b border-black">
        <div className="w-[20%] border-black text-blue-500 ">ID</div>
        <div className="w-[20%] border-black text-blue-500">Username</div>
        <div className="w-[20%] border-black text-blue-500">Name</div>
        <div className="w-[30%] border-black text-blue-500">Email</div>
        <div className="w-[10%] border-black text-blue-500"></div>
      </div>
      {users.map((ele) => (
        <div key={ele.id} className="w-[70%] flex flex-wrap justify-around p-2 bg-custom-bg1 overflow-auto ">
          <div className="w-[20%] border-black text-white">{ele.id}</div>
          <div className="w-[20%] border-black text-white">{ele.userName}</div>
          <div className="w-[20%] border-black text-white">{ele.name}</div>
          <div className="w-[30%] border-black text-white overflow-auto">
            {ele.email}
          </div>
          <div className="w-[10%] border-black">
            <button
              onClick={() => {
                openModalRoot(ele.id);
              }}
              className="bg-blue-600 px-4 py-1 rounded-md text-gray-300"
            >
              Update
            </button>
          </div>
        </div>
      ))}
    </div>
  );
};

export default EditUsers;
