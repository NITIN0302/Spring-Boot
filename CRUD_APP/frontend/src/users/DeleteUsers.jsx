import React, { useState, useEffect } from "react";
import axios from "axios";

const DeleteUsers = () => {
  const [users, setUsers] = useState([]);

  useEffect(() => {
    getUsers();
  }, []);

  const getUsers = async () => {
    const result = await axios.get("http://localhost:8080/users");
    setUsers(result.data);
  };

  const DeleteUsers = (id) =>{

  }

  return (
    <div className="flex flex-wrap justify-center">
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
              }}
              className="bg-blue-600 px-4 py-1 rounded-md text-gray-300"
            >
              Delete
            </button>
          </div>
        </div>
      ))}
    </div>
  );
};

export default DeleteUsers;