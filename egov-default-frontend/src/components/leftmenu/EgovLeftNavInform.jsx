import React from 'react';

import URL from 'constants/url';
import { NavLink } from 'react-router-dom';

function EgovLeftNavInform() { 
    const lastSegment = window.parent.location.href.split('/').pop();
    
    if (lastSegment === 'orders'){
        return (
            <div className="nav">
                <div className="inner">
                    <h2>Order</h2>
                    <ul className="menu4">
                        <li><NavLink to="/order/orders" className={({ isActive }) => (isActive ? "cur" : "")}>Order</NavLink></li>
                    </ul>
                </div>
            </div>
        );
    }
    if (lastSegment === 'products'){
        return (
            <div className="nav">
                <div className="inner">
                    <h2>상품</h2>
                    <ul className="menu4">
                        <li><NavLink to="/inventory/products" className={({ isActive }) => (isActive ? "cur" : "")}>상품</NavLink></li>
                    </ul>
                </div>
            </div>
        );
    }
    return null;
}

export default React.memo(EgovLeftNavInform);