import { BrowserRouter, Route, Routes } from 'react-router-dom';
import React from 'react';
import ReactDOM from 'react-dom/client';
import './index.css';
import Error from './layouts/error/Error';
import Login from './Components/Public/Login';
import Prueba from './Pages/Prueba';
import PageProveedor from './Pages/PageProveedor';
import PageUsuario from './Pages/PageUsuario';
import PageInventario from './Pages/PageInventario';
import PageInsumo from './Pages/PagesInsumo';
import PageEmpresa from './Pages/PageEmpresa';
import PageProducto from './Pages/PageProducto';
import PageFabricacion from './Pages/PagesFabricacion';
import App from './App.tsx';
// import Slider1 from '../public/home/slider1/Slider1';
const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
    <BrowserRouter>
      <Routes>
        <Route exact path='/login' element={ <Login /> }/>
        <Route path='/dashboard' element={<Prueba />}/>
        <Route path='/empresa' element={<PageEmpresa />} />
        <Route path='/proveedor' element={<PageProveedor />} />
        <Route path='/insumo' element={<PageInsumo />} />
        <Route path='/usuario' element={<PageUsuario />} />
        <Route path='fabricacion' element={<PageFabricacion />} />
        <Route path='/producto' element={<PageProducto />} />
        <Route path='/inventario' element={<PageInventario />} />
        <Route path='/prueba' element={<App />} />
        <Route path='*' element={<Error/>} />
      </Routes>
    </BrowserRouter>

);