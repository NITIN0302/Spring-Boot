import React, { useState, useEffect } from "react";
import axios from "axios";

const Home = () => {
  const [users, setUsers] = useState([]);

  useEffect(() => {
    getUsers();
  }, []);

  const getUsers = async () => {
    const result = await axios.get("http://localhost:8080/users");
    setUsers(result.data);
  };

  return (
    <div className="flex flex-wrap justify-center">
      <div className="w-[70%] flex flex-wrap justify-around p-2  mt-4 bg-custom-bg1 border-b border-black">
        <div className="w-[20%] border-black text-blue-500 ">ID</div>
        <div className="w-[25%] border-black text-blue-500">Username</div>
        <div className="w-[25%] border-black  text-blue-500">Name</div>
        <div className="w-[30%] border-black text-blue-500">Email</div>
      </div>
      {users.map((ele) => (
        <div className="w-[70%] flex flex-wrap justify-around p-2 bg-custom-bg1">
          <div className="w-[20%] border-black text-white">{ele.id}</div>
          <div className="w-[25%] border-black text-white">{ele.userName}</div>
          <div className="w-[25%] border-black text-white">{ele.name}</div>
          <div className="w-[30%] border-black text-white">{ele.email}</div>
        </div>
      ))}
    </div>
  );
};

export default Home;
