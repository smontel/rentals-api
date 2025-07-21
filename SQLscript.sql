USE rental_db;

CREATE TABLE user (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255),
    email VARCHAR(255),
    password VARCHAR(255),
    created_at DATE,
    updated_at DATE
);


CREATE TABLE images (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255),
    type VARCHAR(255),
    data LONGBLOB
);


CREATE TABLE messages (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    rental_id INT,
    user_id INT,
    message TEXT
);


CREATE TABLE rentals (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255),
    surface INT,
    price INT,
    picture VARCHAR(255),
    description TEXT,
    owner_id BIGINT,
    created_at DATE,
    updated_at DATE
);


INSERT INTO rentals (
    id, name, surface, price, picture, description, owner_id, created_at, updated_at
) VALUES
(
    1,
    'test house 1',
    432,
    300,
    'https://blog.technavio.org/wp-content/uploads/2018/12/Online-House-Rental-Sites.jpg',
    'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Etiam a lectus eleifend, varius massa ac, mollis tortor. Quisque ipsum nulla, faucibus ac metus a, eleifend efficitur augue. Integer vel pulvinar ipsum. Praesent mollis neque sed sagittis ultricies. Suspendisse congue ligula at justo molestie, eget cursus nulla tincidunt. Pellentesque elementum rhoncus arcu, viverra gravida turpis mattis in. Maecenas tempor elementum lorem vel ultricies. Nam tempus laoreet eros, et viverra libero tincidunt a. Nunc vel nisi vulputate, sodales massa eu, varius erat.',
    1,
    '2012-12-02',
    '2014-12-02'
),
(
    2,
    'test house 2',
    154,
    200,
    'https://blog.technavio.org/wp-content/uploads/2018/12/Online-House-Rental-Sites.jpg',
    'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Etiam a lectus eleifend, varius massa ac, mollis tortor. Quisque ipsum nulla, faucibus ac metus a, eleifend efficitur augue. Integer vel pulvinar ipsum. Praesent mollis neque sed sagittis ultricies. Suspendisse congue ligula at justo molestie, eget cursus nulla tincidunt. Pellentesque elementum rhoncus arcu, viverra gravida turpis mattis in. Maecenas tempor elementum lorem vel ultricies. Nam tempus laoreet eros, et viverra libero tincidunt a. Nunc vel nisi vulputate, sodales massa eu, varius erat.',
    2,
    '2012-12-02',
    '2014-12-02'
),
(
    3,
    'test house 3',
    234,
    100,
    'https://blog.technavio.org/wp-content/uploads/2018/12/Online-House-Rental-Sites.jpg',
    'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Etiam a lectus eleifend, varius massa ac, mollis tortor. Quisque ipsum nulla, faucibus ac metus a, eleifend efficitur augue. Integer vel pulvinar ipsum. Praesent mollis neque sed sagittis ultricies. Suspendisse congue ligula at justo molestie, eget cursus nulla tincidunt. Pellentesque elementum rhoncus arcu, viverra gravida turpis mattis in. Maecenas tempor elementum lorem vel ultricies. Nam tempus laoreet eros, et viverra libero tincidunt a. Nunc vel nisi vulputate, sodales massa eu, varius erat.',
    1,
    '2012-12-02',
    '2014-12-02'
);


