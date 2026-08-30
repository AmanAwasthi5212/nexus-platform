CREATE TABLE shipments (
    id UUID PRIMARY KEY,
    status VARCHAR(50) NOT NULL,

    sender_name VARCHAR(255) NOT NULL,
    receiver_name VARCHAR(255) NOT NULL,

    sender_email VARCHAR(255) NOT NULL,
    receiver_email VARCHAR(255) NOT NULL,

    sender_phone_number VARCHAR(50) NOT NULL,
    receiver_phone_number VARCHAR(50) NOT NULL,

    sender_address_line1 VARCHAR(255) NOT NULL,
    sender_address_line2 VARCHAR(255),
    sender_city VARCHAR(100) NOT NULL,
    sender_state VARCHAR(100),
    sender_postal_code VARCHAR(20) NOT NULL,
    sender_country VARCHAR(100) NOT NULL,

    receiver_address_line1 VARCHAR(255) NOT NULL,
    receiver_address_line2 VARCHAR(255),
    receiver_city VARCHAR(100) NOT NULL,
    receiver_state VARCHAR(100),
    receiver_postal_code VARCHAR(20) NOT NULL,
    receiver_country VARCHAR(100) NOT NULL,

    weight NUMERIC(38,2) NOT NULL,
    weight_unit VARCHAR(20) NOT NULL,
    package_description VARCHAR(500),

    created_at TIMESTAMP WITH TIME ZONE NOT NULL
);
